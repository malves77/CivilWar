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

    private Player player1;
    private CollisionDetector collisionDetector;
    private Screen screen;
    private Enemy[] enemies;
    private int enemiesRemaining;


    public void init() throws InterruptedException {

        //creates screen
        screen = new Screen();
        screen.show();
        screen.displayScore(0);

        //creates map
        Map map = new Map();
        map.show();


        //creates enemies
        enemies = ObjectFactory.enemyFactory(GameObjectsProperties.TOTAL_ENEMIES);
        enemiesRemaining = GameObjectsProperties.TOTAL_ENEMIES;

        //creates weapons
        Weapon[] weapons = ObjectFactory.weaponsFactory(GameObjectsProperties.TOTAL_WEAPONS);



        MyKeyboard keyboard = new MyKeyboard();
        keyboard.init();
        //creates player
        Position playerPosition = new Position(350, 350);
        player1 = new Player(playerPosition, weapons, keyboard);

        player1.show();

        collisionDetector = new CollisionDetector( weapons);

        start(/*enemies,*/ weapons);

    }

    public void start(Weapon[] weapons) throws InterruptedException {




        while(true){

            Thread.sleep(50);
            for(GameObject enemy : enemies) {
                if(enemy instanceof Enemy){
                    Enemy enem = (Enemy) enemy;
                    enem.move();
                    collisionDetector.enemyCollision(enem, enemies);
                }
            }

            for(Weapon weapon : weapons) {
                if(weapon.getFired()){
                    weapon.accelerate();

                    int enemiesKilled = collisionDetector.weaponCollision(weapon, enemies);

                    enemiesRemaining -= enemiesKilled;

                    player1.updateScore(enemiesKilled);

                    screen.displayScore(player1.getScore());
                }
            }


            player1.move();
            collisionDetector.playerEnemyCollision(player1, enemies);
            collisionDetector.reloadSite(player1);
            player1.attack();
            double  division = ((double) enemiesRemaining * 10) / ((double) enemies.length * 10) * 10;
            if(division < GameObjectsProperties.NEW_WAVE_PROB) {
                spawnNewEnemies();
            }

        }
    }

    private void spawnNewEnemies(){
        Enemy[] tempEnemies = new Enemy[enemies.length + 2];

                System.out.println("Spawning new enemies");
        int i = 0;

        for (Enemy enemy : enemies){

            if(!enemy.isDestroyed()){

                tempEnemies[i] = enemy;
                i++;

            }
        }
        System.out.println("old length: " + enemies.length + " new i: " + i);
        for( int j = i; j < tempEnemies.length; j++){

            tempEnemies[j] = ObjectFactory.singleEnemyFactory();

            tempEnemies[i].show();
        }

        enemiesRemaining = tempEnemies.length;
        enemies = tempEnemies;
    }

}
