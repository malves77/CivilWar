package org.academiadecodigo.bootcamp.civilwar.gameobject.player;

import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface.Destroyable;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.Weapon;

public class Player extends GameObject implements PlayerInterface, Destroyable {
    private boolean destroyed = false;
    private int health;
    private final int speed;
    private Direction direction;
    private Weapon solidWeapon;
    private Weapon liquidWeapon;
    private Position myPos;


    public Player(Position myPos, Weapon solidWeapon, Weapon liquidWeapon){
        super(myPos);
        this.health = 10;
        this.speed = 5;
        this.solidWeapon = solidWeapon;
        this.liquidWeapon = liquidWeapon;
        this.myPos = myPos;
        //this.myPos.show();

    }

    public void move(Direction direction){
        this.direction = direction;
        getPosition().moveInDirection(direction, speed);
    }

    public void attack(Weapon weapon){
        weapon.move();
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
}
