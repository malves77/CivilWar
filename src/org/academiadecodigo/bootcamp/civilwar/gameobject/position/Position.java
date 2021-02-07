package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.bootcamp.civilwar.Randomizer;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position implements PositionInterface {

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Rectangle rect;

    public Position(){
        /**
         * Constructor for enemies
         */
        this.width = 10;
        this.height = 10;

        this.xPos = Randomizer.getRandomInRange(Dimensions.getXMap(), Dimensions.getMapWidth() + Dimensions.getXMap() - getWidth());
        this.yPos = Randomizer.getRandomInRange(Dimensions.getYMap(), Dimensions.getMapHeight() + Dimensions.getYMap() - getHeight());


    }

    public Position(int xPos, int yPos) {
        /**
         * Constructor for weapons and players
         * @TODO get width and height from graphic
         */
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = 10;
        this.height = 10;

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

    public void moveLeft( int distance){
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

    public boolean isEdge(Direction direction) {

        return (direction == Direction.UP && yPos == Dimensions.getYMap()) ||
                (direction == Direction.DOWN && yPos == Dimensions.getBottomEdge()) ||
                (direction == Direction.LEFT && xPos == Dimensions.getXMap()) ||
                (direction == Direction.RIGHT && xPos == Dimensions.getRightEdge());
        /*switch (direction) {
            case UP:
                if(yPos - distance < Dimensions.getYMap()) {
                    return true;
                }
                break;
            case DOWN:
                if(yPos + distance + getHeight() > Dimensions.getBottomEdge()) {
                    return true;
                }
                break;
            case LEFT:
                if(xPos - distance < Dimensions.getXMap()) {
                    return true;
                }
                break;
            case RIGHT:
                if(xPos + distance + getWidth() > Dimensions.getRightEdge()) {
                    return true;
                }
                break;
            default:
                System.out.println("No direction provided");
            }
        return false;*/
    }

    public boolean areEqual(Position target){

        return false;
    }

}
