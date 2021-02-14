package org.academiadecodigo.bootcamp.civilwar.gameobject;

import org.academiadecodigo.bootcamp.civilwar.Randomizer;
import org.academiadecodigo.bootcamp.civilwar.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.civilwar.gameobject.enemy.EnemyType;
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

            EnemyType enemyType = EnemyType.ENEMY.getRandomEnemy();

            enemies[i] = new Enemy(randPosition, GameObjectsProperties.ENEMY_SPEED, GameObjectsProperties.ENEMY_HEALTH, enemyType);

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

    public static Enemy singleEnemyFactory(){

        return new Enemy(new Position(), GameObjectsProperties.ENEMY_SPEED, GameObjectsProperties.ENEMY_HEALTH, EnemyType.ENEMY.getRandomEnemy());

    }
}
