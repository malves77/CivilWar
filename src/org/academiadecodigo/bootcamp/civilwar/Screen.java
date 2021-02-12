package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
        width = Dimensions.getScreenWidth();
        height = Dimensions.getScreenHeight();
        rect = new Rectangle(x, y, width, height);
        objectScore = 0;
        textScore = new Text(40,30,objectScore.toString());
        textScore.grow(20, 30);



    }

    public void show(){
        rect.setColor(Color.ORANGE);
        rect.fill();
        Picture background = new Picture(0, 0, "fundo800x600.png");
        background.draw();
    }

    public void displayScore(int score) {
        objectScore = score;
        textScore.setText(objectScore.toString());
        textScore.draw();
    }

}
