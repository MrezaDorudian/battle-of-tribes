public class Sling extends Weapon {
    public Sling(){
        super();
        setDamage(2500);
        setCoolDown(10);

    }

    @Override
    public boolean canHit(Tile destinationTile, Tile currentTile) {
        int curRow = currentTile.getRow();
        int curColumn = currentTile.getColumn();
        int desRow = destinationTile.getRow();
        int desColumn = destinationTile.getColumn();
        /*towers considered that can't attack each other
        so that we check <<!(destinationTile.getExistence() instanceof Tower)>>
        */
        if (Math.abs(desRow - curRow) < 3 && Math.abs(desColumn - curColumn) < 3 && ((desColumn != curColumn) || (desRow != curRow))) {
            if (!(destinationTile.getExistence() instanceof Tower) && destinationTile.getExistence().isAlive) {
                return true;
            }
        }
        return false;
    }
}
