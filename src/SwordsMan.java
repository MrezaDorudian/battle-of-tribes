public class SwordsMan extends Unit{
    public SwordsMan(){
        super();
        setWeapon(new Sword());
        setArmor(new Metal());
        setHitPoint(5000);
        setMovementDelay(2);//2 without the armor
        setAttackDelay(new Sword().getCoolDown());//bayad too method ++ she
    }


    @Override
    public void attack(Tile destinationTile) {
        int curRow = getCurrentTile().getRow();
        int curColumn = getCurrentTile().getColumn();
        int desRow = destinationTile.getRow();
        int desColumn = destinationTile.getColumn();
        if (Math.abs(desRow -  curRow) < 2 && Math.abs(desColumn - curColumn) < 2 && ((desColumn != curColumn) || (desRow != curRow))){
            if (!(destinationTile.getExistence() instanceof Tower) && destinationTile.getExistence().isAlive)
                ((SwordsMan) destinationTile.getExistence()).takeDamage(new Sword().getDamage());
        }
    }

    @Override
    public void takeDamage(int damage) {
        setHitPoint(getHitPoint() - (damage * (100 - new Metal().getDamageReduction()) / 100));
    }



}
