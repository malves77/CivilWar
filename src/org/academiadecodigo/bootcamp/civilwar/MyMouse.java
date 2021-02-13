package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MyMouse implements MouseHandler {

    private InputManager inputManager;

    private Mouse mouse;
    //private Player player;

    private MouseEvent mouseEventClicked;
    private MouseEvent mouseEventMoved;

    public MyMouse(InputManager inputManager){
        mouse = new Mouse(this);
        this.inputManager = inputManager;
        init();
    }

    public void init() {
        System.out.println("Mouse Init");
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        mouseEventClicked = new MouseEvent(20, 20, MouseEventType.MOUSE_CLICKED);
        //mouseEventMoved = new MouseEvent(20, 20, MouseEventType.MOUSE_MOVED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("Mouse Clicked");
        if(mouseEvent.getEventType() == MouseEventType.MOUSE_CLICKED) {
            System.out.println("MouseClicked!");
            System.out.println("Calling game...");
            inputManager.startPlaying();
        } else
            System.out.println("Clicked, nothing done");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        //System.out.println("Mouse Moving!");

        if(mouseEvent.getEventType() == MouseEventType.MOUSE_MOVED) {
            //System.out.println("Mouse Moved!");
            mouseEventClicked.setX(mouseEvent.getX());
            mouseEventClicked.setX(mouseEvent.getX());
        }

    }
}
