package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

public enum Direction {

    UP,
    DOWN,
    RIGHT,
    LEFT,
    DIAGONAL_UPRIGHT,
    DIAGONAL_UPLEFT,
    DIAGONAL_DOWNRIGHT,
    DIAGONAL_DOWNLEFT;

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

