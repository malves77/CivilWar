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

        start(enemies);
        //creates weapons
        /*Position weaponPos1 = new Position(map.getX(), map.getY(), 10, 10);
        weaponPos1.show();
        Weapon weapon1 = new Weapon(weaponPos1, WeaponType.FRANCESINHA);
        Position weaponPos2 = new Position(map.getX()+ 20 , map.getY()+ 20,10,10);
        weaponPos2.show();
        Weapon weapon2 = new Weapon(weaponPos2, WeaponType.VINHO_DO_PORTO);*/

        /*//creates players
        Position playerPosition = new Position(20, 20);
        playerPosition.show();
        Player player = new Player(playerPosition, weapon1, weapon2);
*/
    }

    public void start(GameObject[] gameObjects) throws InterruptedException {

        while(true){

            Thread.sleep(50);
            for(GameObject enemy : gameObjects) {
                if(enemy instanceof Enemy){
                    Enemy enem = (Enemy) enemy;
                    enem.move();
                }
            }
        }


    }
}
