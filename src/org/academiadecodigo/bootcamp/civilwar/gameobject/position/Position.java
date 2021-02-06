package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.bootcamp.civilwar.Randomizer;

public class Position implements PositionInterface {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    public Position(int width, int height){
        this.width = width;
        this.height = height;

        this.xPos = Randomizer.getRandomInRange(Dimensions.getXMap(), Dimensions.getMapWidth() + Dimensions.getXMap() - getWidth());
        this.yPos = Randomizer.getRandomInRange(Dimensions.getYMap(), Dimensions.getMapHeight() + Dimensions.getYMap() - getHeight());


    }

    public Position(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

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
                moveUp(direction, distance);
                break;
            case DOWN:
                moveDown(direction, distance);
                break;
            case LEFT:
                moveLeft(direction, distance);
                break;
            case RIGHT:
                moveRight(direction, distance);
                break;
        }
    }

    public void moveUp(Direction direction, int distance){
        if(isEdge(direction, distance)) {
            yPos = Dimensions.getYMap();
        } else {
            yPos -= distance;
        }
    }

    public void moveDown(Direction direction, int distance){
        if(isEdge(direction, distance)) {
            yPos = Dimensions.getBottomEdge() - getHeight();
        } else {
            yPos += distance;
        }
    }

    public void moveLeft(Direction direction, int distance){
        if(isEdge(direction, distance)) {
            xPos = Dimensions.getXMap();
        } else {
            xPos -= distance;
        }
    }

    public void moveRight(Direction direction, int distance){
        if(isEdge(direction, distance)){
            xPos = Dimensions.getRightEdge() - getWidth();
        } else {
            xPos += distance;
        }
    }

    public boolean isEdge(Direction direction, int distance) {

        switch (direction) {
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
        return false;
    }

    public boolean areEqual(Position target){

        return false;
    }
}
