public class MovementAction extends Action {
    private Tile destinationTile;
    public MovementAction(Tile destinationTile, Existence existence){
        super(existence);
        this.destinationTile = destinationTile;
    }

    @Override
    public void doAction() {
        if (destinationTile)
    }

}
