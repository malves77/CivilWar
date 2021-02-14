package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MyMouse implements MouseHandler {

    private InputManager inputManager;

    private Mouse mouse;

    private MouseEvent mouseEventClicked;
    private MouseEvent mouseEventMoved;

    public MyMouse(InputManager inputManager){
        mouse = new Mouse(this);
        this.inputManager = inputManager;
        init();
    }

    public void init() {
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        mouseEventClicked = new MouseEvent(20, 20, MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getEventType() == MouseEventType.MOUSE_CLICKED) {
            inputManager.startPlaying();
        } else
            System.out.println("Clicked, nothing done");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

        if(mouseEvent.getEventType() == MouseEventType.MOUSE_MOVED) {
            mouseEventClicked.setX(mouseEvent.getX());
            mouseEventClicked.setX(mouseEvent.getX());
        }

    }
}
