public class Tower extends Existence {
    public Tower(){
        super();
        setArmor(new Rock());
        setWeapon(new Sling());
//        setHitPoint(1);//here '1' means infinite
//        setAttackDelay(new Sling().getCoolDown());
    }

    @Override
    public void attack(Tile destinationTile) {
        if (getWeapon().canHit(destinationTile, getCurrentTile()))
            ((Unit)destinationTile.getExistence()).takeDamage(getWeapon().getDamage());
    }
}
