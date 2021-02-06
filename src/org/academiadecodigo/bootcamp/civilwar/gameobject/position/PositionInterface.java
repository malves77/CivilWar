package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

public interface PositionInterface {


    int getX();
    int getY();

    int getWidth();
    int getHeight();


    void moveInDirection(Direction direction, int distance);

    void moveUp(Direction direction, int distance);
    void moveDown(Direction direction, int distance);
    void moveLeft(Direction direction, int distance);
    void moveRight(Direction direction, int distance);

    boolean isEdge(Direction direction, int distance);

    boolean areEqual(Position target);

}
