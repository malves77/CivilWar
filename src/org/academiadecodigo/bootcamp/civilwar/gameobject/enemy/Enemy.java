package org.academiadecodigo.bootcamp.civilwar.gameobject.enemy;

import org.academiadecodigo.bootcamp.civilwar.Randomizer;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface.Destroyable;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Enemy extends GameObject implements EnemyInterface, Destroyable {

    private Position myPos;
    private int speed;
    private int size;
    private Rectangle rect;
    private Direction currentDirection;
    private int changeDirectionLevel = 8;
    private int health;

    public Enemy(Position myPos, int speed) {
        super(myPos);
        this.myPos = myPos;
        this.speed = speed;
        health = 20;
        size = 20;
        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        rect = new Rectangle(myPos.getX(), myPos.getY(), size, size);
    }

    public Enemy(Position myPos, int speed, int health) {
        super(myPos);
        this.myPos = myPos;
        this.speed = speed;
        this.health = health;
        size = 20;
        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        rect = new Rectangle(myPos.getX(), myPos.getY(), size, size);
    }

    public void move() {
        int oldX = myPos.getX();
        int oldY = myPos.getY();

        accelerate(chooseDirection());

        int newX = myPos.getX();
        int newY = myPos.getY();

        this.rect.translate(newX - oldX, newY - oldY);
        show();
    }

    private void accelerate(Direction direction){
        if(isDestroyed()){
            return;
        }
        Direction newDirection = direction;
        if(getPosition().isEdge(direction) && newDirection.equals(currentDirection)){
            newDirection = chooseDirection();
        }
        this.currentDirection = newDirection;

        for(int speed = 0; speed < this.speed; speed++){
            getPosition().moveInDirection(newDirection, 1);
            //collision detector here TO DO
        }

    }

    public void show() {
        rect.setColor(Color.BLACK);
        rect.fill();
    }

    public Direction chooseDirection() {
        /*int rand = Randomizer.getRandomWithMax(4);
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
        return null;*/
        Direction newDirection = currentDirection;
        if(Math.random() > (double) changeDirectionLevel / 10){
            newDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        }
        return newDirection;
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

    public Position getPosition(){
        return myPos;
    }
}
