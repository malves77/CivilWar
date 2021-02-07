package org.academiadecodigo.bootcamp.civilwar;


import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.Map;
import org.academiadecodigo.bootcamp.civilwar.gameobject.ObjectFactory;
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

    public void init(){

        //creates screen
        Screen screen = new Screen();
        screen.show();

        //creates map
        Map map = new Map();
        map.show();
        //creates enemies


        //creates weapons
        Position weaponPos1 = new Position(map.getX(), map.getY(), 10, 10);
        weaponPos1.show();
        Weapon weapon1 = new Weapon(weaponPos1, WeaponType.FRANCESINHA);
        Position weaponPos2 = new Position(map.getX(), map.getY(),10,10);
        weaponPos2.show();
        Weapon weapon2 = new Weapon(weaponPos2, WeaponType.VINHO_DO_PORTO);

        //creates players
        Position playerPosition = new Position(20, 20);
        Player player = new Player(playerPosition, weapon1, weapon2);

    }

}
