package org.academiadecodigo.bootcamp.civilwar.gameobject;

import org.academiadecodigo.bootcamp.civilwar.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.Weapon;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.WeaponType;

/**
 * Instantiates GameObjects
 * Create Players
 * Create Tourists
 */

public class ObjectFactory {

    public static Enemy[] enemyFactory(int enemyNum) {

        Enemy[] enemies = new Enemy[enemyNum];

        for (int i = 0; i < enemies.length; i++) {
            Position randPosition = new Position();
            enemies[i] = new Enemy(randPosition, GameObjectsProperties.ENEMY_SPEED, GameObjectsProperties.ENEMY_HEALTH);

        }
        return enemies;
    }

    public static Weapon[] weaponsFactory(int weaponNum) {

        Weapon[] weapons = new Weapon[weaponNum];

        for (int i = 0; i < weapons.length; i++) {
            WeaponType weaponType = WeaponType.values()[(int) (Math.random() * WeaponType.values().length)];
            weapons[i] = new Weapon(weaponType);
        }
        return weapons;
    }

}
