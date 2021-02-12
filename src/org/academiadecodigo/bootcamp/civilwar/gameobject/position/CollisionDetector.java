package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.civilwar.gameobject.player.Player;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.Weapon;

public class CollisionDetector /*implements CollisionDetectorInterface*/ {

    private Enemy[] enemies;
    private Weapon[] weapons;

    public CollisionDetector(Enemy[] gameObjects, Weapon[] weapons) {
        this.enemies = gameObjects;
        this.weapons = weapons;
    }

    public void enemyCollision(Enemy enemy) {
        for (Enemy anotherEnemy : enemies) {

            if (enemy == anotherEnemy || anotherEnemy.isDestroyed()) {
                continue;
            }
            int enemyX = enemy.getPosition().getX();
            int enemyXWidth = enemyX + enemy.getPosition().getWidth();
            int enemyY = enemy.getPosition().getY();
            int enemyYHeight = enemyY + enemy.getPosition().getHeight();

            int goX = anotherEnemy.getPosition().getX();
            int goXWidth = goX + anotherEnemy.getPosition().getWidth();
            int goY = anotherEnemy.getPosition().getY();
            int goYHeight = goY + anotherEnemy.getPosition().getHeight();

            if (
                    enemyX <= goXWidth &&
                            enemyXWidth >= goX &&
                            enemyY <= goYHeight &&
                            enemyYHeight >= goY

            ) {
                //System.out.println("collided!!!!");
                enemy.setOppositeDirection();
                anotherEnemy.setOppositeDirection();
            }
        }
    }

    public int weaponCollision(Weapon weapon) {
        for (Enemy enemy : enemies) {
            if (weapon.isDestroyed() || enemy.isDestroyed()) {
                continue;
            }

            int enemyX = enemy.getPosition().getX();
            int enemyXWidth = enemyX + enemy.getPosition().getWidth();
            int enemyY = enemy.getPosition().getY();
            int enemyYHeight = enemyY + enemy.getPosition().getHeight();

            int weaponX = weapon.getPosition().getX();
            int weaponXWidth = weaponX + weapon.getPosition().getWidth();
            int weaponY = weapon.getPosition().getY();
            int weaponYHeight = weaponY + weapon.getPosition().getHeight();

            if (
                    enemyX <= weaponXWidth &&
                            enemyXWidth >= weaponX &&
                            enemyY <= weaponYHeight &&
                            enemyYHeight >= weaponY) {
                weapon.setDestroyed();
                enemy.hit(weapon.getDamage());
                if (enemy.isDestroyed()) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public void playerEnemyCollision(Player player){

        for (Enemy enemy : enemies) {
            if (player.isDestroyed() || enemy.isDestroyed()) {
                continue;
            }

            int enemyX = enemy.getPosition().getX();
            int enemyXWidth = enemyX + enemy.getPosition().getWidth();
            int enemyY = enemy.getPosition().getY();
            int enemyYHeight = enemyY + enemy.getPosition().getHeight();

            int weaponX = player.getPosition().getX();
            int weaponXWidth = weaponX + player.getPosition().getWidth();
            int weaponY = player.getPosition().getY();
            int weaponYHeight = weaponY + player.getPosition().getHeight();

            if (
                enemyX <= weaponXWidth &&
                enemyXWidth >= weaponX &&
                enemyY <= weaponYHeight &&
                enemyYHeight >= weaponY
            )
            {
                //System.out.println("player was hit by enemy");
                player.hit(enemy.getPower());

            }
        }

    }

}
