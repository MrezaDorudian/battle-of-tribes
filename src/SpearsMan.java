public class SpearsMan extends Unit{
    public SpearsMan(){
        super();
        setWeapon(new Spear());
        setArmor(new Metal());
        setHitPoint(3000);
        setMovementDelay(1);
        setAttackDelay(new Spear().getCoolDown());
    }

    @Override
    public void attack(Tile destinationTile) {
        int curRow = getCurrentTile().getRow();
        int curColumn = getCurrentTile().getColumn();
        int desRow = destinationTile.getRow();
        int desColumn = destinationTile.getColumn();
        if (getTeamName().equals("team 1"))
            if (Math.abs(desColumn - curColumn) < 2 && (Math.abs(desRow - curRow) == 1 || Math.abs(desRow - curRow) == 2) && desRow > curRow)
                if (!(destinationTile.getExistence() instanceof Tower) && destinationTile.getExistence().isAlive)
                    ((SpearsMan) destinationTile.getExistence()).takeDamage(new Spear().getDamage());
        else if (getTeamName().equals("team 2"))
            if (Math.abs(desColumn - curColumn) < 2 && (Math.abs(desRow - curRow) == 1 || Math.abs(desRow - curRow) == 2) && curRow > desRow)
                if (!(destinationTile.getExistence() instanceof Tower && destinationTile.getExistence().isAlive))
                    ((SpearsMan) destinationTile.getExistence()).takeDamage(new Spear().getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        setHitPoint(getHitPoint() - (damage * (100 - new Metal().getDamageReduction()) / 100));
    }
}
