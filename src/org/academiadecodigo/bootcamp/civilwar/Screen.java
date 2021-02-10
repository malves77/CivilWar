package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Screen {
    private int x;
    private int y;
    private int padding;
    private int width;
    private int height;
    private Rectangle rect;
    private Integer objectScore;
    private Text textScore;

    public Screen(){
        x = 0;
        y = 0;
        padding = 10;
        width = Dimensions.getRightEdge();
        height = Dimensions.getBottomEdge();
        rect = new Rectangle(x, y, width, height);
        objectScore = 0;
        textScore = new Text(40,30,objectScore.toString());
        textScore.grow(20, 30);



    }

    public void show(){
        rect.setColor(Color.WHITE);
        rect.fill();
    }

    public void displayScore(int score) {
        objectScore = score;
        textScore.setText(objectScore.toString());
        textScore.draw();
    }

}
