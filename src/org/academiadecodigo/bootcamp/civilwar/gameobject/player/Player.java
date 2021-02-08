package org.academiadecodigo.bootcamp.civilwar.gameobject.player;

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


    public Player(Position myPos, Weapon[] weapons ){
        super(myPos);
        this.health = 10;
        this.speed = 5;
        this.weapons = weapons;
        this.shotsFired = 0;
        this.myPos = myPos;
        this.size = 20;
        this.rect = new Rectangle(myPos.getX(), myPos.getY(), size, size);
        //this.myPos.show();

    }

    public void move(Direction direction){

        int oldX = myPos.getX();
        int oldY = myPos.getY();

        this.direction = direction;
        System.out.println("Moving");
        getPosition().moveInDirection(direction, speed);

        int newX = myPos.getX();
        int newY = myPos.getY();

        rect.translate(newX - oldX, newY - oldY);
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
