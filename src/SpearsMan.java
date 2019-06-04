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
    public void takeDamage(int damage) {
        setHitPoint(getHitPoint() - (damage * (100 - new Metal().getDamageReduction()) / 100));
    }
}
