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
    public void takeDamage(int damage) {
        setHitPoint(getHitPoint() - (damage * (100 - new Metal().getDamageReduction()) / 100));
    }



}
