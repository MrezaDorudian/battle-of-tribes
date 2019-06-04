public class Tile {
    private int row;
    private int column;
    private Existence existence;

    public Tile(){
        existence = null;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Existence getExistence() {
        return existence;
    }
}
