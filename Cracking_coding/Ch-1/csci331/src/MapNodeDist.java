public class MapNodeDist {

    private String identifier;
    private int distance;

    public MapNodeDist(String id, int dist) {
        identifier = id;
        distance = dist;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getDistance() {
        return distance;
    }

}
