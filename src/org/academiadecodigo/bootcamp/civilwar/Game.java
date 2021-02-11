package org.academiadecodigo.bootcamp.civilwar;


import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.Map;
import org.academiadecodigo.bootcamp.civilwar.gameobject.ObjectFactory;
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
        Enemy[] enemies = new Enemy[2];

        for (int i = 0; i < enemies.length; i++){
            int x = Randomizer.getRandomInRange(Dimensions.getXMap(), Dimensions.getRightEdge());
            int y = Randomizer.getRandomInRange(Dimensions.getYMap(), Dimensions.getBottomEdge());
            Position pos = new Position(x, y);
            enemies[i] = new Enemy(pos, 5, 2);
            System.out.println("New enemy created");
        }

        //creates weapons
        Weapon[] weapons = new Weapon[60];
        for(int i = 0; i < weapons.length; i++){
            weapons[i] = new Weapon(WeaponType.FRANCESINHA);
        }



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

            player1.attack();
        }


    }
}
