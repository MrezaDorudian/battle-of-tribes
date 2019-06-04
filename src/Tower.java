public class Tower extends Unit {
    public Tower(){
        super();
        setArmor(new Rock());
        setWeapon(new Sling());
        setHitPoint(1);//here '1' means infinite
        setAttackDelay(new Sling().getCoolDown());
    }

    @Override
    public void takeDamage(int damage) {
        setHitPoint(getHitPoint() - (damage * (100 - new Rock().getDamageReduction()) / 100));
    }
}
