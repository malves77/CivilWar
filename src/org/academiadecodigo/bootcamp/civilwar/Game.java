package org.academiadecodigo.bootcamp.civilwar;


import org.academiadecodigo.bootcamp.civilwar.gameobject.*;
import org.academiadecodigo.bootcamp.civilwar.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.civilwar.gameobject.player.Player;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.CollisionDetector;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.Weapon;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.WeaponType;

/**
 * Initiate Game(Objects)
 * Start Game
 */
public class Game {

    //private GameObject = new GameObject();
    Player player1;
    CollisionDetector collisionDetector;
    Screen screen;


    public void init() throws InterruptedException {

        //creates screen
        screen = new Screen();
        screen.show();
        screen.displayScore(0);

        //creates map
        Map map = new Map();
        map.show();


        //creates enemies
        Enemy[] enemies = ObjectFactory.enemyFactory(GameObjectsProperties.TOTAL_ENEMIES);


        //creates weapons
        Weapon[] weapons = ObjectFactory.weaponsFactory(GameObjectsProperties.TOTAL_WEAPONS);



        MyKeyboard keyboard = new MyKeyboard();
        keyboard.init();
        //creates player
        Position playerPosition = new Position(350, 350);
        player1 = new Player(playerPosition, weapons, keyboard);

        player1.show();

        //Collision detector
        collisionDetector = new CollisionDetector(enemies, weapons);

        start(enemies, weapons);

    }

    public void start(GameObject[] gameObjects, Weapon[] weapons) throws InterruptedException {

        while(true){

            Thread.sleep(50);
            for(GameObject enemy : gameObjects) {
                if(enemy instanceof Enemy){
                    Enemy enem = (Enemy) enemy;
                    enem.move();
                    collisionDetector.enemyCollision(enem);
                }
            }
            for(Weapon weapon : weapons) {
                if(weapon.getFired()){
                    weapon.accelerate();
                    player1.updateScore(collisionDetector.weaponCollision(weapon));
                    screen.displayScore(player1.getScore());
                    System.out.println(player1.getScore());
                }
            }


            player1.move();
            collisionDetector.playerEnemyCollision(player1);
            player1.attack();
        }
    }
}
