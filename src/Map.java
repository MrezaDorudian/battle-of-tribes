public class Map {
    private static int dimension;
    private static Tile[][] tiles;
    public Map(){
        tiles = new Tile[dimension][dimension];
    }

    public static int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        Map.dimension = dimension;
    }

    public static Tile[][] getTiles() {
        return tiles;
    }
}