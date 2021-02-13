package org.academiadecodigo.bootcamp.civilwar.gameobject.player;

import org.academiadecodigo.bootcamp.civilwar.MyKeyboard;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObjectsProperties;
import org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface.Destroyable;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.Weapon;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.WeaponType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObject implements PlayerInterface, Destroyable {

    private int score;
    private boolean destroyed = false;
    private int health;
    private final int speed;
    private Direction direction;
    private Weapon[] weapons;
    private int shotsFired;
    private Position myPos;
    private Rectangle rect;
    private Picture pic;
    private int size;
    private boolean canFire = true;
    private boolean gotHit = false;
    private int reloadTime;
    private int protectionTime;

    private MyKeyboard keyboard;

    public Player(Position myPos, Weapon[] weapons, MyKeyboard keyboard) {
        super(myPos);
        this.score = 0;
        this.health = GameObjectsProperties.PLAYER_HEALTH;
        this.speed = GameObjectsProperties.PLAYER_SPEED;
        this.weapons = weapons;
        this.shotsFired = 0;
        this.myPos = myPos;
        this.size = GameObjectsProperties.PLAYER_SIZE;
        //this.rect = new Rectangle(myPos.getX(), myPos.getY(), size, size);
        this.pic = new Picture(myPos.getX(), myPos.getY(), "se64.png");
        //this.myPos.show();
        this.keyboard = keyboard;
        this.direction = Direction.LEFT;

        protectionTime = GameObjectsProperties.PLAYER_PROTECTION_TIME;
        reloadTime = GameObjectsProperties.RELOAD_TIME;

    }


    public void move() {
        boolean keysPressed[] = keyboard.getKeysPressed();

        int oldX = myPos.getX();
        int oldY = myPos.getY();

        if (choosePlayerDir(keysPressed) != null) {
            //System.out.println("Moving");

            this.direction = choosePlayerDir(keysPressed);

            getPosition().moveInDirection(direction, speed);

            int newX = myPos.getX();
            int newY = myPos.getY();

            //rect.translate(newX - oldX, newY - oldY);
            pic.translate(newX - oldX, newY - oldY);



        }
    }

    public Direction choosePlayerDir(boolean[] keysPressed) {
        Direction dir = null;
        int key1 = -1;
        int key2 = -1;
        for (int i = 0; i < keysPressed.length - 1; i++) {
            if (keysPressed[i]) {
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
        if (key2 < 0) {
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
            switch (key1) {
                case 0:
                    switch (key2) {
                        case 2:
                            dir = Direction.DIAGONAL_UPLEFT;
                            break;
                        case 3:
                            dir = Direction.DIAGONAL_UPRIGHT;
                        default:
                            //System.out.println("Some ERROR HAS OCCURRED!");
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
                            //System.out.println("Some ERROR HAS OCCURRED!");
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
                            //System.out.println("Some ERROR HAS OCCURRED!");
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
                            //System.out.println("Some ERROR HAS OCCURRED!");
                    }
                    break;
                default:
                    //System.out.println("Some ERROR HAS OCCURRED!");
            }
        }
        return dir;
    }

    public Position getPosition(){
        return myPos;
    }

    public void attack() {

        if (keyboard.getKeysPressed()[4] && canFire) {
            if (!(shotsFired == weapons.length)) {
                //attackTimer.startCounting();
                canFire = false;
                weapons[shotsFired].setFired();
                weapons[shotsFired].move(new Position(myPos.getX(), myPos.getY()), this.direction);
                shotsFired++;
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                canFire = true;
                            }
                        },
                        reloadTime
                );
            }
        }
    }

    /**
     * @TODO reset when in specific place
     */
    public void resetShotsFired() {
        shotsFired = 0;
        for (Weapon weapon : weapons) {
            weapon.respawn();
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void hit(int damage) {
        if(gotHit){
            return;
        }
        //System.out.println("player really got hit");
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        gotHit = false;
                    }
                },
                protectionTime
        );

        health -= damage;

        if (health <= 0) {
            health = 0;
            setDestroyed();
            System.out.println("Game over");
        }
        gotHit = true;
    }

    /**
     * @TODO implement game over
     */
    private void setDestroyed() {
        destroyed = true;
    }


    public void show() {
        //rect.setColor(Color.WHITE);
        //rect.fill();
        pic.draw();
    }

    public void updateScore(int enemyValue) {
        score += enemyValue;
    }
    public int getScore (){
        return score;
    }

    public void reload(WeaponType weaponType){

        for(int i = shotsFired - 1; i >= 0; i--){

            weapons[i] = new Weapon(weaponType);

        }

        shotsFired = 0;
    }
}
