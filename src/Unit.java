import java.awt.*;

public abstract class Unit extends Existence {
    private String teamName;
    private int hitPoint;
    private int movementDelay;
    private int attackDelay;

    public abstract void attack(Tile destinationTile);
    public abstract void takeDamage(int damage);



    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void setMovementDelay(int movementDelay) {
        this.movementDelay = movementDelay;
    }

    public void setAttackDelay(int attackDelay) {
        this.attackDelay = attackDelay;
    }



    /*because the units can just move forward until they reach the end of map and then turn back or they move
    left or right as they see a tower, the method move() dont get any argument*/
    public void move() {
        if (teamName.equals("team 1")) {
            if (getCurrentTile().getRow() == 0) {
                if (canMove("top") == 1)
                    getCurrentTile().setRow(getCurrentTile().getRow() + 1);
                else if (canMove("top") == 0){
                    if (canMove("right") == 1)
                        getCurrentTile().setColumn(getCurrentTile().getColumn() + 1);
                    else if (canMove("left") == 1)
                        getCurrentTile().setColumn(getCurrentTile().getColumn() - 1);
                }
            } else{
                if (canMove("down") == 1)
                    getCurrentTile().setRow(getCurrentTile().getRow() - 1);
                else if (canMove("down") == 0){
                    if (canMove("right") == 1)
                        getCurrentTile().setColumn(getCurrentTile().getColumn() + 1);
                    else if (canMove("left") == 1)
                        getCurrentTile().setColumn(getCurrentTile().getColumn() - 1);
                }
            }
        }
        else {
            if (getCurrentTile().getRow() == Map.getDimension() - 1) {
                if (canMove("down") == 1)
                    getCurrentTile().setRow(getCurrentTile().getRow() - 1);
                else if (canMove("down") == 0 + 0){
                    if (canMove("right") == 1)
                        getCurrentTile().setColumn(getCurrentTile().getColumn() + 1);
                    else if (canMove("left") == 1)
                        getCurrentTile().setColumn(getCurrentTile().getColumn() - 1);
                }
            } else {
                if (canMove("top") == 1)
                    getCurrentTile().setRow(getCurrentTile().getRow() + 1);
                else if (canMove("top") == 0 + 0){
                    if (canMove("right") == 1)
                        getCurrentTile().setColumn(getCurrentTile().getColumn() + 1);
                    else if (canMove("left") == 1)
                        getCurrentTile().setColumn(getCurrentTile().getColumn() - 1);
                }
            }
        }
    }

    public int canMove(String direction) {//return: 0 means towers, 1 means nothing, 2 means soldiers and -1 means there is a problem
        int row = getCurrentTile().getRow();
        int column = getCurrentTile().getColumn();
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



    public String getTeamName() {
        return teamName;
    }
}
