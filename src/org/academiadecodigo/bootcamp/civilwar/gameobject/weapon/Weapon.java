package org.academiadecodigo.bootcamp.civilwar.gameobject.weapon;

import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObjectsProperties;
import org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface.Destroyable;
import org.academiadecodigo.bootcamp.civilwar.gameobject.player.Player;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Weapon extends GameObject implements Destroyable, WeaponInterface {

    private int damage;
    private boolean destroyed;
    private WeaponType type;
    private Direction currentDirection;
    private Player player;
    private int speed;
    private Position myPos;
    private Rectangle rect;
    private boolean fired;

    public Weapon( WeaponType type) {
        this.damage = type.getDamage();
        destroyed = false;
        this.type = type;
        this.speed = GameObjectsProperties.WEAPON_SPEED;
        //currentDirection = player.getDirection();
    }

    public void setDestroyed() {
        destroyed = true;
        rect.delete();

    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void hit(int damage) {
        setDestroyed();
    }

    public void move(Position pos, Direction direction) {
        //atribuir
        if (isDestroyed()){
            return;
        }
        this.myPos = pos;
        currentDirection = direction;
        show();
        accelerate();
    }

    public void accelerate () {

        if (isDestroyed()){
            return;
        }

        int oldX = myPos.getX();
        int oldY = myPos.getY();
        //System.out.println("Moving weapon");
        for (int speed = 0; speed < this.speed; speed++) {
            myPos.moveInDirection(currentDirection, 1);
            if(myPos.isEdge(currentDirection)){
                setDestroyed();
            }
        }

        int newX = myPos.getX();
        int newY = myPos.getY();

        rect.translate(newX - oldX, newY - oldY);
    }

    public void setFired(){
        fired = true;
    }

    public boolean getFired(){
        return fired;
    }

    public void respawn(){
        destroyed = false;
    }

    public void show(){
        rect = new Rectangle(myPos.getX(), myPos.getY(), 10, 10);
        rect.setColor(Color.GRAY);
        rect.fill();
    }

    public Position getPosition(){
        return myPos;
    }

    public int getDamage(){
        return damage;
    }
}
