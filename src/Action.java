public abstract class Action {
    private Existence existence;
    public Action(Existence existence){
        this.existence = existence;
    }

    public void setExistence(Existence existence) {
        this.existence = existence;
    }

    public Existence getExistence() {
        return existence;
    }

    public abstract void doAction();
}
