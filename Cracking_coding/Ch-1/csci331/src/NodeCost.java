public class NodeCost {

    private String identifier;
    private String parent;
    private int cost;

    public NodeCost(String id, String p, int c) {
        identifier = id;
        parent = p;
        cost = c;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getParent() {
        return parent;
    }

    public int getCost() {
        return cost;
    }

}
