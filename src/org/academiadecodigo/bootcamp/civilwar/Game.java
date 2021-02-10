package org.academiadecodigo.bootcamp.civilwar;


import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.Map;
import org.academiadecodigo.bootcamp.civilwar.gameobject.ObjectFactory;
import org.academiadecodigo.bootcamp.civilwar.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.civilwar.gameobject.player.Player;
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


    public void init() throws InterruptedException {

        //creates screen
        Screen screen = new Screen();
        screen.show();

        //creates map
        Map map = new Map();
        map.show();


        //creates enemies
        GameObject enemies[] = new GameObject[4];

        for (int i = 0; i < enemies.length; i++){
            Position pos = new Position(20, 20);
            enemies[i] = new Enemy(pos, 5, 20);
            System.out.println("New enemy created");
        }

        //creates weapons
        Weapon[] weapons = new Weapon[10];
        for(int i = 0; i < weapons.length; i++){
            weapons[i] = new Weapon(WeaponType.FRANCESINHA);
        }



        MyKeyboard keyboard = new MyKeyboard();
        keyboard.init();
        //creates player
        Position playerPosition = new Position(350, 350);
        player1 = new Player(playerPosition, weapons, keyboard);

        player1.show();

        start(enemies, weapons);

    }

    public void start(GameObject[] gameObjects, Weapon[] weapons) throws InterruptedException {

        while(true){

            Thread.sleep(10);
            for(GameObject enemy : gameObjects) {
                if(enemy instanceof Enemy){
                    Enemy enem = (Enemy) enemy;
                    enem.move();
                }
            }
            for(Weapon weapon : weapons) {
                if(weapon.getFired()){
                    weapon.accelerate();
                }
            }
            player1.move();
            player1.attack();

        }


    }
}
