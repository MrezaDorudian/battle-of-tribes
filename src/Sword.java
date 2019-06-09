public class Sword extends Weapon {
    public Sword(){
        super();
        setDamage(2000);
        setCoolDown(1);
    }

    @Override
    public boolean canHit(Tile destinationTile, Tile currentTile) {
        int curRow = currentTile.getRow();
        int curColumn = currentTile.getColumn();
        int desRow = destinationTile.getRow();
        int desColumn = destinationTile.getColumn();

        if (Math.abs(desRow -  curRow) < 2 && Math.abs(desColumn - curColumn) < 2 && ((desColumn != curColumn) || (desRow != curRow))){
            if (!(destinationTile.getExistence() instanceof Tower) && destinationTile.getExistence().isAlive) {
                return true;
            }
        }
        return false;
    }
}
