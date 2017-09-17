import java.util.ArrayList;
import java.util.List;

public class MapNode {

    private String identifier;
    private int heuristic;
    private List<MapNodeDist> neighbors;

    public MapNode(String id, int h) {
        identifier = id;
        heuristic = h;
        neighbors = new ArrayList<MapNodeDist>();
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public List<MapNodeDist> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor (MapNodeDist element) {
        neighbors.add(element);
    }

}
