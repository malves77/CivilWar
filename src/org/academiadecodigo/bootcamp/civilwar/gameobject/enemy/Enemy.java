package org.academiadecodigo.bootcamp.civilwar.gameobject.enemy;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Animator;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObjectsProperties;
import org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface.Destroyable;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Enemy extends GameObject implements EnemyInterface, Destroyable {

    private Position myPos;
    private int speed;
    private int size;
    private Rectangle rect;
    private Picture pic;
    private Direction currentDirection;
    private int changeDirectionLevel = GameObjectsProperties.ENEMY_CHANGEDIRECTIONLEVEL;
    private int health;
    private boolean destroyed;
    private int power;
    private Animator animator;
    private EnemyType type;

    public Enemy(Position myPos, int speed, EnemyType enemyType) {
        super(myPos);
        destroyed = false;
        this.myPos = myPos;
        this.speed = GameObjectsProperties.ENEMY_SPEED;
        power = GameObjectsProperties.ENEMY_POWER;
        health = GameObjectsProperties.ENEMY_HEALTH;
        size = GameObjectsProperties.ENEMY_SIZE;
        this.type = enemyType;
        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        //rect = new Rectangle(myPos.getX(), myPos.getY(), size, size);
        pic = new Picture(myPos.getX(), myPos.getY(), type.getPathToFolder() + "/runDown/1.png");
        this.animator = new Animator(myPos.getX(), myPos.getY(), type.getPathToFolder());
        //this.show();
    }

    public Enemy(Position myPos, int speed, int health, EnemyType enemyType) {
        super(myPos);
        destroyed = false;
        this.myPos = myPos;
        this.speed = speed;
        power = GameObjectsProperties.ENEMY_POWER;
        this.health = health;
        this.type = enemyType;
        size = GameObjectsProperties.ENEMY_SIZE;
        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        pic = new Picture(myPos.getX(), myPos.getY(), type.getPathToFolder() + "/runDown/1.png");
        this.animator = new Animator(myPos.getX(), myPos.getY(), type.getPathToFolder());
    }

    public void move() {
        if(isDestroyed()){
            return;
        }


        int oldX = myPos.getX();
        int oldY = myPos.getY();

        accelerate(chooseDirection());

        int newX = myPos.getX();
        int newY = myPos.getY();

        pic.load(animator.animate(currentDirection.getRunDir()));
        pic.translate(newX - oldX, newY - oldY);
        show();
    }

    private void accelerate(Direction direction){
        Direction newDirection = direction;
        if(getPosition().isEdge(direction) && newDirection.equals(currentDirection)){
            newDirection = chooseDirection();
        }
        this.currentDirection = newDirection;

        for(int speed = 0; speed < this.speed; speed++){
            getPosition().moveInDirection(newDirection, 1);
        }

    }

    public void show() {
        /*rect.setColor(Color.BLACK);
        rect.fill();*/
        pic.draw();

    }

    public Direction chooseDirection() {

        Direction newDirection = currentDirection;
        if(Math.random() > (double) changeDirectionLevel / 10){
            newDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        }
        return newDirection;
    }
    public void setDestroyed(){
        destroyed = true;
        //rect.delete();
        pic.delete();
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void hit(int damage) {
        if (health - damage > 0) {
            health -= damage;
            //System.out.println("Damage taken");
            //System.out.println(getHealth());
        } else {
            health = 0;
            setDestroyed();
            //System.out.println("destroyed");
        }
    }

    public int getHealth() {
        return health;
    }

    public Position getPosition(){
        return myPos;
    }

    public void setOppositeDirection(){
        currentDirection = currentDirection.getOpposite();
    }

    public int getPower(){
        return power;
    }
}
