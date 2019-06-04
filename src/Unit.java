import java.awt.*;

public abstract class Unit extends Existence {
    private String teamName;
    private int hitPoint;
    private int movementDelay;
    private int attackDelay;
    private Tile currentTile;

    public abstract void attack();
    public abstract void takeDamage(int damage);

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void setMovementDelay(int movementDela) {
        this.movementDelay = movementDela;
    }
    public void setAttackDelay(int attackDelay) {
        this.attackDelay = attackDelay;
    }

    public void move() {
        if (teamName.equals("team 1")) {
            if (currentTile.getRow() == 0) {
                if (canMove("top"))
                    currentTile.setColumn(currentTile.getColumn() + 1);
            }
            else {
                if (canMove("down"))
                    currentTile.setColumn(currentTile.getColumn() - 1);
            }
        } else {
            if (currentTile.getRow() == Map.getDimension() - 1) {
                if (canMove("down"))
                    currentTile.setColumn(currentTile.getColumn() - 1);
            }else {
                if (canMove("top"))
                    currentTile.setColumn(currentTile.getColumn() + 1);
            }
        }
    }


    public boolean canMove(String direction){
        int row = currentTile.getRow();
        int column = currentTile.getColumn();
        if (direction.equals("top"))
            return !(Map.getTiles()[row + 1][column].getExistence() instanceof Tower);
        else
            return !(Map.getTiles()[row - 1][column].getExistence() instanceof Tower);
    }
}
