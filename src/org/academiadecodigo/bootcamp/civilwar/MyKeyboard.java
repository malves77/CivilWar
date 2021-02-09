package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.bootcamp.civilwar.gameobject.player.Player;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler {

    //KeyBoardThreadHandler keyThreads;
    private Keyboard keyboard;
    //private Player player;

    private KeyboardEvent eventUp;
    private KeyboardEvent eventDown;
    private KeyboardEvent eventLeft;
    private KeyboardEvent eventRight;
    private KeyboardEvent eventShoot;


    private KeyboardEvent eventUpRelease;
    private KeyboardEvent eventDownRelease;
    private KeyboardEvent eventLeftRelease;
    private KeyboardEvent eventRightRelease;
    private KeyboardEvent eventShootRelease;

    //private Thread t;
    private boolean keysPressed[];

    public MyKeyboard(){

        keysPressed = new boolean[5];
        for(boolean k: keysPressed)
            k = false;

        keyboard = new Keyboard(this);
        //this.player = player;

        init();
    }

    public boolean[] getKeysPressed() {
        return keysPressed;
    }

    public void init(){

        //t = new Thread(this);

        eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        eventUpRelease = new KeyboardEvent();
        eventUpRelease.setKey(KeyboardEvent.KEY_UP);
        eventUpRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        eventDownRelease = new KeyboardEvent();
        eventDownRelease.setKey(KeyboardEvent.KEY_DOWN);
        eventDownRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        eventLeftRelease = new KeyboardEvent();
        eventLeftRelease.setKey(KeyboardEvent.KEY_LEFT);
        eventLeftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        eventRightRelease = new KeyboardEvent();
        eventRightRelease.setKey(KeyboardEvent.KEY_RIGHT);
        eventRightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        eventShoot = new KeyboardEvent();
        eventShoot.setKey(KeyboardEvent.KEY_SPACE);
        eventShoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        eventShootRelease = new KeyboardEvent();
        eventShootRelease.setKey(KeyboardEvent.KEY_SPACE);
        eventShootRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(eventUp);
        keyboard.addEventListener(eventDown);
        keyboard.addEventListener(eventLeft);
        keyboard.addEventListener(eventRight);
        keyboard.addEventListener(eventShoot);
        keyboard.addEventListener(eventUpRelease);
        keyboard.addEventListener(eventDownRelease);
        keyboard.addEventListener(eventLeftRelease);
        keyboard.addEventListener(eventRightRelease);
        keyboard.addEventListener(eventShootRelease);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            //if(keyboardEvent.getKey() == keyboard.)
            keysPressed[0] = true;
            System.out.println("Up Pressed");
            //player.move(Direction.UP);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            keysPressed[1] = true;
            System.out.println("Down Pressed");
            //player.move(Direction.DOWN);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            keysPressed[2] = true;
            System.out.println("Left Pressed");
            //player.move(Direction.LEFT);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            keysPressed[3] = true;
            System.out.println("Right Pressed");
            //player.move(Direction.RIGHT);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            keysPressed[4] = true;
            //player.attack();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){

        System.out.println("Key Released!");

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            keysPressed[0] = false;
            //player.move(Direction.UP);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            System.out.println("Down Released");
            keysPressed[1] = false;
            //player.move(Direction.DOWN);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            System.out.println("Left Released");
            keysPressed[2] = false;
            //player.move(Direction.LEFT);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            System.out.println("Right Released");
            keysPressed[3] = false;
            //player.move(Direction.RIGHT);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            keysPressed[4] = false;
            //player.attack();
        }
    }


}
