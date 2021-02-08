package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.bootcamp.civilwar.gameobject.player.Player;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;

    public MyKeyboard(Player player){
        keyboard = new Keyboard(this);
        this.player = player;
    }

    public void init(){
        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eventShoot = new KeyboardEvent();
        eventShoot.setKey(KeyboardEvent.KEY_SPACE);
        eventShoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(eventUp);
        keyboard.addEventListener(eventDown);
        keyboard.addEventListener(eventLeft);
        keyboard.addEventListener(eventRight);
        keyboard.addEventListener(eventShoot);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            player.move(Direction.UP);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN){
            player.move(Direction.DOWN);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT){
            player.move(Direction.LEFT);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            player.move(Direction.RIGHT);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            player.attack();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){

    }
}
