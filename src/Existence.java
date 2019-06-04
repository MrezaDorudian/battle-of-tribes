public abstract class Existence {
    private Tile tile;
    private Weapon weapon;
    private Armor armor;
    boolean isAlive;
    int id;

    public Existence(){
        isAlive = true;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public abstract void act();
}
