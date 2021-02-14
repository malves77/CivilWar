package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

public enum Direction {

    UP("runUp"),
    DOWN("runDown"),
    RIGHT("runRight"),
    LEFT("runLeft"),
    DIAGONAL_UPRIGHT("runUpRight"),
    DIAGONAL_UPLEFT("runUpLeft"),
    DIAGONAL_DOWNRIGHT("runDownRight"),
    DIAGONAL_DOWNLEFT("runDownLeft");

    private String runDir;

    Direction (String runDir){
        this.runDir = runDir;
    };

    public String getRunDir() {
        return runDir;
    }

    public Direction getOpposite(){
        Direction opposite = null;
        switch (this) {
            case UP:
                opposite = Direction.DOWN;
                break;
            case DOWN:
                opposite = Direction.UP;
                break;
            case RIGHT:
                opposite = Direction.LEFT;
                break;
            case LEFT:
                opposite = Direction.RIGHT;
                break;
            case DIAGONAL_UPRIGHT:
                opposite = Direction.DIAGONAL_DOWNLEFT;
                break;
            case DIAGONAL_UPLEFT:
                opposite = Direction.DIAGONAL_DOWNRIGHT;
                break;
            case DIAGONAL_DOWNRIGHT:
                opposite = Direction.DIAGONAL_UPLEFT;
                break;
            case DIAGONAL_DOWNLEFT:
                opposite = Direction.DIAGONAL_UPRIGHT;
                break;
        }
        return opposite;
        }
}



