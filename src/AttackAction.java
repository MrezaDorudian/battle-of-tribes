public class AttackAction extends Action {
    private Unit toBeAttackedUnit;
    public AttackAction(Unit toBeAttackedUnit, Existence existence) {
        super(existence);
        this.toBeAttackedUnit = toBeAttackedUnit;
    }
    @Override
    public void doAction(){
        ((Unit)getExistence()).attack(toBeAttackedUnit.getCurrentTile());
    }
}
