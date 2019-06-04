public abstract class Weapon {
    private int damage;
    private int coolDown;


    public abstract boolean canHit();

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public int getDamage() {
        return damage;
    }

    public int getCoolDown() {
        return coolDown;
    }
}
