public class SpearsMan extends Unit{
    private String direction;
    public SpearsMan(){
        super();
        setWeapon(new Spear());
        setArmor(new Metal());
        setHitPoint(3000);
        setMovementDelay(1);
        setAttackDelay(new Spear().getCoolDown());
        if (getTeamName().equals("team 1"))
            direction = "down";
        else
            direction = "top";
    }
    @Override
    public void attack(Tile destinationTile) {
        if (getWeapon().canHit(destinationTile, getCurrentTile()))
            ((Unit)destinationTile.getExistence()).takeDamage(getWeapon().getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        setHitPoint(getHitPoint() - (damage * (100 - new Metal().getDamageReduction()) / 100));
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
