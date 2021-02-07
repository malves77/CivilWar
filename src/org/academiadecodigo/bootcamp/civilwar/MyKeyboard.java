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
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_UP);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(event);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent){
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP){
            player.move(Direction.UP);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){

    }
}
