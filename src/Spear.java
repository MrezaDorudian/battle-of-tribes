public class Spear extends Weapon {
    public Spear(){
        super();
        setDamage(1500);
        setCoolDown(2);
    }

    @Override
    public boolean canHit(Tile destinationTile, Tile currentTile) {
        int curRow = currentTile.getRow();
        int curColumn = currentTile.getColumn();
        int desRow = destinationTile.getRow();
        int desColumn = destinationTile.getColumn();
        if (((SpearsMan)currentTile.getExistence()).getDirection().equals("top")) {
            if (Math.abs(desColumn - curColumn) < 2 && (Math.abs(desRow - curRow) == 1 || Math.abs(desRow - curRow) == 2) && desRow > curRow) {
                if (!(destinationTile.getExistence() instanceof Tower) && destinationTile.getExistence().isAlive) {
                    return true;
                }
            }
        }else if (((SpearsMan)currentTile.getExistence()).getDirection().equals("down")) {
            if (Math.abs(desColumn - curColumn) < 2 && (Math.abs(desRow - curRow) == 1 || Math.abs(desRow - curRow) == 2) && curRow > desRow) {
                if (!(destinationTile.getExistence() instanceof Tower && destinationTile.getExistence().isAlive)) {
                    return true;
                }
            }
        }
        return false;
    }
}
