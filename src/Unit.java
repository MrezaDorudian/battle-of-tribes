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
                if (canMove("top") == 1)
                    currentTile.setRow(currentTile.getRow() + 1);
                else if (canMove("top") == 0){
                    if (canMove("right") == 1)
                        currentTile.setColumn(currentTile.getColumn() + 1);
                    else if (canMove("left") == 1)
                        currentTile.setColumn(currentTile.getColumn() - 1);
                }
            } else{
                if (canMove("down") == 1)
                    currentTile.setRow(currentTile.getRow() - 1);
                else if (canMove("down") == 0){
                    if (canMove("right") == 1)
                        currentTile.setColumn(currentTile.getColumn() + 1);
                    else if (canMove("left") == 1)
                        currentTile.setColumn(currentTile.getColumn() - 1);
                }
            }
        }
        else {
            if (currentTile.getRow() == Map.getDimension() - 1) {
                if (canMove("down") == 1)
                    currentTile.setRow(currentTile.getRow() - 1);
                else if (canMove("down") == 0 + 0){
                    if (canMove("right") == 1)
                        currentTile.setColumn(currentTile.getColumn() + 1);
                    else if (canMove("left") == 1)
                        currentTile.setColumn(currentTile.getColumn() - 1);
                }
            } else {
                if (canMove("top") == 1)
                    currentTile.setRow(currentTile.getRow() + 1);
                else if (canMove("top") == 0 + 0){
                    if (canMove("right") == 1)
                        currentTile.setColumn(currentTile.getColumn() + 1);
                    else if (canMove("left") == 1)
                        currentTile.setColumn(currentTile.getColumn() - 1);
                }
            }
        }
    }
    public int canMove(String direction) {//0 means towers, 1 means nothing, 2 means soldiers and -1 means there is a problem
        int row = currentTile.getRow();
        int column = currentTile.getColumn();
        if (direction.equals("top")) {
            if (Map.getTiles()[row + 1][column].getExistence() instanceof Tower)
                return 0;
            else if (Map.getTiles()[row + 1][column].getExistence() instanceof SwordsMan)
                return 2;
            else if (Map.getTiles()[row + 1][column].getExistence() instanceof SpearsMan)
                return 2;
            else if (!(Map.getTiles()[row + 1][column].getExistence() instanceof Unit))
                return 1;
        } else if (direction.equals("down")) {
            if (Map.getTiles()[row - 1][column].getExistence() instanceof Tower)
                return 0;
            else if (Map.getTiles()[row - 1][column].getExistence() instanceof SwordsMan)
                return 2;
            else if (Map.getTiles()[row - 1][column].getExistence() instanceof SpearsMan)
                return 2;
            else if (!(Map.getTiles()[row - 1][column].getExistence() instanceof Unit))
                return 1;
        } else if (direction.equals("right")) {
            if (Map.getTiles()[row][column + 1].getExistence() instanceof Tower)
                return 0;
            else if (Map.getTiles()[row][column + 1].getExistence() instanceof SwordsMan)
                return 2;
            else if (Map.getTiles()[row][column + 1].getExistence() instanceof SpearsMan)
                return 2;
            else if (!(Map.getTiles()[row][column + 1].getExistence() instanceof Unit))
                return 1;
        } else if (direction.equals("left")) {
            if (Map.getTiles()[row][column - 1].getExistence() instanceof Tower)
                return 0;
            else if (Map.getTiles()[row][column - 1].getExistence() instanceof SwordsMan)
                return 2;
            else if (Map.getTiles()[row][column - 1].getExistence() instanceof SpearsMan)
                return 2;
            else if (!(Map.getTiles()[row][column - 1].getExistence() instanceof Unit))
                return 1;
        }
        return -1;
    }
}
