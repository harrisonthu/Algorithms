import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pathfinding {

    private enum SearchMethod {BFS, BACKTRACKING, A_STAR}

    private SearchMethod searchMethod;
    private Map<String, MapNode> mapNodes;
    private File inputFile;

    public Pathfinding (SearchMethod method, String filename) {
        searchMethod = method;
        inputFile = new File(filename);
        mapNodes = new HashMap<String, MapNode>();
    }

    public void initialize() {
        // parse text file, build data structures
        try {
            Scanner fileScanner = new Scanner(inputFile);

            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();

                // format: "SUS 22: GOL 30, INS 44, ..."
                Pattern r = Pattern.compile("([A-z]*) ([0-9]*): (.*)");
                Matcher m = r.matcher(line);
                m.find();

                String identifier = m.group(1);
                int heuristic = Integer.parseInt(m.group(2));
                String neighbors = m.group(3);

                // create new node
                MapNode newNode = new MapNode(identifier, heuristic);

                // add all neighbors
                String[] neighborList = neighbors.split(",");

                for (String neighbor : neighborList) {
                    // format: "GOL 30"
                    Pattern r2 = Pattern.compile("([A-z]+) ([0-9]+)");
                    Matcher m2 = r2.matcher(neighbor);
                    m2.find();

                    String neighborId = m2.group(1);
                    int neighborDist = Integer.parseInt(m2.group(2));

                    newNode.addNeighbor(new MapNodeDist(neighborId, neighborDist));
                }

                mapNodes.put(identifier, newNode);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            quitWithMessage("File not found.");
        }

        // prompt for start and finish nodes
        String startNode = getNode("start");
        String finishNode = getNode("finish");

        // perform corresponding search
        switch (searchMethod) {
            case BFS:
                performBfs(startNode, finishNode);
                break;
            case BACKTRACKING:
                performBacktracking(startNode, finishNode);
                break;
            case A_STAR:
                performAStar(startNode, finishNode);
                break;
        }
    }

    private String getNode(String type) {
        System.out.print("Enter " + type + " node: ");
        Scanner s = new Scanner(System.in);
        String node = s.next();
        return node;
    }

    private void performBfs(String start, String finish) {
        System.out.println("Performing BFS...");

        Queue<String> q = new LinkedList<String>();
        Set<String> explored = new HashSet<String>();
        Map<String, NodeCost> nodeToParent = new HashMap<String, NodeCost>();
        q.add(start);
        nodeToParent.put(start, new NodeCost(start, null, 0));

        if (start == finish) {
            System.out.println("Path: " + start);
            System.out.println("Cost: 0");
            return;
        }

        // continue until queue is empty (should never be empty with provided graph)
        while (!q.isEmpty()) {
            String currentNodeId = q.remove();
            explored.add(currentNodeId);

            MapNode currentNode = mapNodes.get(currentNodeId);
            List<MapNodeDist> children = currentNode.getNeighbors();

            // look at each child node
            for (MapNodeDist child : children) {
                String childId = child.getIdentifier();
                if (!explored.contains(childId) && !q.contains(childId)) {

                    nodeToParent.put(childId, new NodeCost(childId, currentNodeId, child.getDistance()));

                    // found the finish node -> determine path and cost
                    if (childId.equals(finish)) {
                        List<String> path = new ArrayList<String>();
                        int cost = 0;

                        NodeCost parent = nodeToParent.get(childId);
                        while (parent != null) {
                            path.add(0, parent.getIdentifier());
                            cost += parent.getCost();
                            parent = nodeToParent.get(parent.getParent());
                        }

                        System.out.print("Path: ");
                        for (int i = 0; i < path.size(); i++) {
                            if (i == path.size() - 1) {
                                System.out.println(path.get(i));
                            } else {
                                System.out.print(path.get(i) + " -> ");
                            }
                        }

                        System.out.println("Cost: " + Integer.toString(cost));
                        System.exit(0);

                    } else {
                        q.add(child.getIdentifier());
                    }
                }
            }

        }
    }

    private void performBacktracking(String start, String finish) {

    }

    private void performAStar(String start, String finish) {

    }

    public static void main (String args[]) {
        if (args.length != 2) {
            quitWithMessage("Invalid input parameters.");
        }

        SearchMethod method = null;
        switch (args[0]) {
            case "bfs":
                method = SearchMethod.BFS;
                break;
            case "backtracking":
                method = SearchMethod.BACKTRACKING;
                break;
            case "a*":
                method = SearchMethod.A_STAR;
                break;
            default:
                quitWithMessage("Invalid method name.");
        }

        Pathfinding p = new Pathfinding(method, args[1]);
        p.initialize();
    }

    public static void quitWithMessage(String message) {
        System.out.println(message);
        System.out.println("Usage: java Pathfinding <method name (bfs, backtracking, a*)> <input file>");
        System.exit(0);
    }
}
