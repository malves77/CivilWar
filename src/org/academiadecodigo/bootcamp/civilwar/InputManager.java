package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class InputManager {

    private Game gameRef;
    private MyMouse myMouse;

    private boolean canPlay;

    public InputManager(Game gameRef) {
        this.gameRef = gameRef;
        myMouse = new MyMouse(this);
        canPlay = false;
        System.out.println("Input Created with " + myMouse);
    }

    public boolean canPlay() throws InterruptedException {
        return canPlay;
    }

    public void startPlaying() {
        canPlay = true;
    }


}
