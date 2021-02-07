package org.academiadecodigo.bootcamp.civilwar.gameobject.weapon;

import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface.Destroyable;
import org.academiadecodigo.bootcamp.civilwar.gameobject.player.Player;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;

public class Weapon extends GameObject implements Destroyable, WeaponInterface {

    private int damage;
    private boolean destroyed;
    private WeaponType type;
    private Direction currentDirection;
    private Player player;
    private int speed;
    private Position pos;


    public Weapon( WeaponType type) {
        destroyed = false;
        this.type = type;
        //currentDirection = player.getDirection();
    }

    public void setDestroyed() {
        destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }


    public void hit(int damage) {
        setDestroyed();
    }

    public void move(Position pos, Direction direction) {
        //atribuir
        this.pos = pos;
        currentDirection = direction;
        accelerate();
    }

    private void accelerate () {

        if (isDestroyed()){
            return;
        }
        for (int speed = 0; speed < this.speed; speed++) {
            super.getPosition().moveInDirection(currentDirection, 1);
        }
    }
}
