package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

public interface PositionInterface {


    int getX();
    int getY();

    int getWidth();
    int getHeight();


    void moveInDirection(Direction direction, int distance);

    void moveUp( int distance);
    void moveDown( int distance);
    void moveLeft(int distance);
    void moveRight( int distance);

    boolean isEdge(Direction direction);

    boolean areEqual(Position target);

}
