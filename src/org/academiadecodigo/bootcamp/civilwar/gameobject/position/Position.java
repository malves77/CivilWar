package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObjectsProperties;
import org.academiadecodigo.bootcamp.civilwar.Randomizer;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position implements PositionInterface {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public Position(){
        /**
         * Constructor for enemies
         */
        this.width = GameObjectsProperties.ENEMY_SIZE;
        this.height = GameObjectsProperties.ENEMY_SIZE;

        this.xPos = Randomizer.getRandomInRange(Dimensions.getXMap(), Dimensions.getMapWidth()/2 + Dimensions.getXMap() - getWidth());
        this.yPos = Randomizer.getRandomInRange(Dimensions.getYMap(), Dimensions.getMapHeight()/2 + Dimensions.getYMap() - getHeight());

    }

    public Position(int xPos, int yPos) {
        /**
         * Constructor for weapons and players
         * @TODO get width and height from graphic
         */
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = GameObjectsProperties.PLAYER_SIZE;
        this.height = GameObjectsProperties.PLAYER_SIZE;

    }

    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void moveInDirection(Direction direction, int distance){
        switch (direction) {
            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
            case DIAGONAL_UPLEFT:
                moveUpLeft(distance);
                break;
            case DIAGONAL_UPRIGHT:
                moveUpRight(distance);
                break;
            case DIAGONAL_DOWNLEFT:
                moveDownLeft(distance);
                break;
            case DIAGONAL_DOWNRIGHT:
                moveDownRight(distance);
                break;
        }
    }

    public void moveUp(int distance){
        if(yPos - distance < Dimensions.getYMap()) {
            yPos = Dimensions.getYMap();
        } else {
            yPos -= distance;
        }
    }

    public void moveDown( int distance){
        if(yPos + distance > Dimensions.getBottomEdge() - getHeight()) {
            yPos = Dimensions.getBottomEdge() - getHeight();
        } else {
            yPos += distance;
        }
    }

    public void moveLeft(int distance){
        if(xPos - distance < Dimensions.getXMap()) {
            xPos = Dimensions.getXMap();
        } else {
            xPos -= distance;
        }
    }

    public void moveRight(int distance){
        if(xPos + distance > Dimensions.getRightEdge() - getWidth()){
            xPos = Dimensions.getRightEdge() - getWidth();
        } else {
            xPos += distance;
        }
    }

    public void moveUpRight(int distance){
        if(xPos + distance > Dimensions.getRightEdge() - getWidth()){
            xPos = Dimensions.getRightEdge() - getWidth();
        } else {
            xPos += distance;
        }

        if(yPos - distance < Dimensions.getYMap()) {
            yPos = Dimensions.getYMap();
        } else {
            yPos -= distance;
        }
    }

    public void moveUpLeft(int distance){
        //check left
        if(xPos - distance < Dimensions.getXMap() ){
            xPos = Dimensions.getXMap();
        } else {
            xPos -= distance;
        }

        //check upper
        if(yPos - distance < Dimensions.getYMap()){
            yPos = Dimensions.getYMap();
        } else {
            yPos -= distance;
        }
    }

    public void moveDownRight(int distance){
        if(xPos + distance > Dimensions.getRightEdge() - getWidth() ){
            xPos = Dimensions.getRightEdge() - getWidth();

        } else {
            xPos += distance;

        }

        if(yPos + distance > Dimensions.getBottomEdge() - getHeight()){
            yPos = Dimensions.getBottomEdge() - getHeight();
        } else {
            yPos += distance;
        }
    }

    public void moveDownLeft(int distance){
        if(xPos - distance < Dimensions.getXMap() ){
            xPos = Dimensions.getXMap();
        } else {
            xPos -= distance;
        }

        if(yPos + distance > Dimensions.getBottomEdge() - getHeight()) {
            yPos = Dimensions.getBottomEdge() - getHeight();
        } else {
            yPos += distance;
        }
    }


    public boolean isEdge(Direction direction) {

        return ( //upper wall
                direction == Direction.UP && yPos <= Dimensions.getYMap()) ||
                (direction == Direction.DIAGONAL_UPLEFT && yPos <= Dimensions.getYMap()) ||
                (direction == Direction.DIAGONAL_UPRIGHT && yPos <= Dimensions.getYMap()) ||
                //bottom wall
                (direction == Direction.DOWN && yPos + height == Dimensions.getBottomEdge()) ||
                (direction == Direction.DIAGONAL_DOWNLEFT && yPos + height == Dimensions.getBottomEdge())||
                (direction == Direction.DIAGONAL_DOWNRIGHT && yPos + height == Dimensions.getBottomEdge()) ||
                //left wall
                (direction == Direction.LEFT && xPos == Dimensions.getXMap()) ||
                (direction == Direction.DIAGONAL_DOWNLEFT && xPos == Dimensions.getXMap()) ||
                (direction == Direction.DIAGONAL_UPLEFT && xPos == Dimensions.getXMap()) ||
                //right wall
                (direction == Direction.RIGHT && xPos + width == Dimensions.getRightEdge()) ||
                (direction == Direction.DIAGONAL_DOWNRIGHT && xPos + width == Dimensions.getRightEdge()) ||
                (direction == Direction.DIAGONAL_UPRIGHT && xPos + width == Dimensions.getRightEdge());

    }

    public boolean areEqual(Position target){

        return false;
    }

}
