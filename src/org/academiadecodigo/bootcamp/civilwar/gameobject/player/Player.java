package org.academiadecodigo.bootcamp.civilwar.gameobject.player;

import org.academiadecodigo.bootcamp.civilwar.MyKeyboard;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface.Destroyable;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player extends GameObject implements PlayerInterface, Destroyable {

    private boolean destroyed = false;
    private int health;
    private final int speed;
    private Direction direction;
    private Weapon[] weapons;
    private int shotsFired;
    private Position myPos;
    private Rectangle rect;
    private int size;

    private MyKeyboard keyboard;

    public Player(Position myPos, Weapon[] weapons, MyKeyboard keyboard){
        super(myPos);
        this.health = 10;
        this.speed = 5;
        this.weapons = weapons;
        this.shotsFired = 0;
        this.myPos = myPos;
        this.size = 20;
        this.rect = new Rectangle(myPos.getX(), myPos.getY(), size, size);
        //this.myPos.show();
        this.keyboard = keyboard;
        this.direction = Direction.LEFT;

    }

    public void move(/*Direction direction*/){
        boolean keysPressed[] = keyboard.getKeysPressed();

        int oldX = myPos.getX();
        int oldY = myPos.getY();

        if(choosePlayerDir(keysPressed) != null) {
            System.out.println("Moving");

            this.direction = choosePlayerDir(keysPressed);

            getPosition().moveInDirection(direction, speed);

            int newX = myPos.getX();
            int newY = myPos.getY();

            rect.translate(newX - oldX, newY - oldY);
        }
    }

    public Direction choosePlayerDir(boolean[] keysPressed) {
        Direction dir = null;
        int key1 = -1;
        int key2 = -1;
        for(int i = 0; i < keysPressed.length; i++) {
            if(keysPressed[i]) {
                if (key1 < 0) {
                    key1 = i;
                } else if (key2 < 0) {
                    key2 = i;
                } else {
                    System.out.println("Keys are full. Can't add another key.");
                    break;
                }
            }
        }
        if(key2 < 0) {
            switch (key1) {
                case 0:
                    dir = Direction.UP;
                    break;
                case 1:
                    dir = Direction.DOWN;
                    break;
                case 2:
                    dir = Direction.LEFT;
                    break;
                case 3:
                    dir = Direction.RIGHT;
            }
        } else {
            switch(key1) {
                case 0:
                    switch (key2) {
                        case 2:
                            dir = Direction.DIAGONAL_UPLEFT;
                            break;
                        case 3:
                            dir = Direction.DIAGONAL_UPRIGHT;
                        default:
                            System.out.println("Some ERROR AS OCCURED!");
                    }
                    break;
                case 1:
                    switch (key2) {
                        case 2:
                            dir = Direction.DIAGONAL_DOWNLEFT;
                            break;
                        case 3:
                            dir = Direction.DIAGONAL_DOWNRIGHT;
                        default:
                            System.out.println("Some ERROR AS OCCURED!");
                    }
                    break;
                case 2:
                    switch (key2) {
                        case 0:
                            dir = Direction.DIAGONAL_UPLEFT;
                            break;
                        case 1:
                            dir = Direction.DIAGONAL_DOWNLEFT;
                            break;
                        default:
                            System.out.println("Some ERROR AS OCCURED!");
                    }
                    break;
                case 3:
                    switch (key2) {
                        case 0:
                            dir = Direction.DIAGONAL_UPRIGHT;
                            break;
                        case 1:
                            dir = Direction.DIAGONAL_DOWNRIGHT;
                            break;
                        default:
                            System.out.println("Some ERROR AS OCCURED!");
                    }
                    break;
                default:
                    System.out.println("Some ERROR AS OCCURED!");
            }
        }
        return dir;
    }

    public void attack(){

        if(!(shotsFired == weapons.length)){
            System.out.println("fired " + shotsFired + " shots");
            weapons[shotsFired].setFired();
            weapons[shotsFired].move(new Position(myPos.getX(), myPos.getY()), this.direction);
            shotsFired++;
        }

    }

    /**
     * @TODO reset when in specific place
     */
    public void resetShotsFired() {
        shotsFired = 0;
        for(Weapon weapon : weapons) {
            weapon.respawn();
        }
    }

    public boolean isDestroyed(){
        return destroyed;
    }

    public void hit(int damage){
        if(!isDestroyed()){
            health -= damage;
        }

        if(health <= 0) {
            health = 0;
            setDestroyed();
        }
    }

    private void setDestroyed(){
        destroyed = true;
    }

    public Direction getDirection() {
        return direction;
    }

    public void show(){
        rect.setColor(Color.WHITE);
        rect.fill();

    }
}
