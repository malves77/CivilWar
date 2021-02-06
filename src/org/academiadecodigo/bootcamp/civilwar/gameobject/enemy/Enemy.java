package org.academiadecodigo.bootcamp.civilwar.gameobject.enemy;

import org.academiadecodigo.bootcamp.civilwar.Randomizer;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface.Destroyable;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;

public class Enemy extends GameObject implements EnemyInterface, Destroyable {

    private Position myPos;
    private int speed;

    private int health;

    public Enemy(Position myPos, int speed) {
        super(myPos);
        this.myPos = myPos;
        this.speed = speed;
        health = 20;
    }

    public Enemy(Position myPos, int speed, int health) {
        super(myPos);
        this.myPos = myPos;
        this.speed = speed;
        this.health = health;
    }

    public void move() {
        this.getPosition().moveInDirection(chooseDirection(), speed);
    }

    public Direction chooseDirection() {
        int rand = Randomizer.getRandomInRange(4);
        switch (rand) {
            case 1:
                return Direction.UP;
            case 2:
                return Direction.DOWN;
            case 3:
                return Direction.LEFT;
            case 4:
                return Direction.RIGHT;
            default:
                System.out.println("Error in direction choosing");
        }
        return null;
    }

    public boolean isDestroyed() {

        if(getHealth() <= 0) {
            return true;
        }
        return false;
    }

    public void hit(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

}
