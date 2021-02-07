package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Screen {
    private int x;
    private int y;
    private int padding;
    private int width;
    private int height;
    private Rectangle rect;

    public Screen(){
        x = 0;
        y = 0;
        padding = 10;
        width = Dimensions.getRightEdge()  + padding * 2;
        height = Dimensions.getBottomEdge() + padding * 2;
        rect = new Rectangle(x, y, width, height);
    }

    public void show(){
        rect.setColor(Color.GREEN);
        rect.fill();
    }

}
