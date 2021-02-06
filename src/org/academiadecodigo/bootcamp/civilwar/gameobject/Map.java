package org.academiadecodigo.bootcamp.civilwar.gameobject;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Map {

    private int width;
    private int height;
    private Rectangle rect;

    public Map (){
        this.width = Dimensions.getMapWidth();
        this.height = Dimensions.getMapHeight();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void show(){
        rect = new Rectangle( Dimensions.getXMap(), Dimensions.getYMap(), getWidth(), getHeight());
        rect.setColor(Color.BLUE);
        rect.fill();
    }

    public int getX(){
        return rect.getX();
    }

    public int getY(){
        return rect.getY();
    }



}
