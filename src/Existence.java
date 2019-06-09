public abstract class Existence {
    private Tile currentTile;
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

    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public abstract void act();
}
