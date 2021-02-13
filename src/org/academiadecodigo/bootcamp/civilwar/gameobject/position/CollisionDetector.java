package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.civilwar.gameobject.player.Player;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.Weapon;
import org.academiadecodigo.bootcamp.civilwar.gameobject.weapon.WeaponType;

public class CollisionDetector /*implements CollisionDetectorInterface*/ {

    private Weapon[] weapons;
    private boolean hasReloaded;

    public CollisionDetector( Weapon[] weapons) {
        this.weapons = weapons;
        hasReloaded = false;
    }

    public void enemyCollision(Enemy enemy, Enemy[] enemies) {

        for (Enemy anotherEnemy : enemies) {

            if (enemy == anotherEnemy || anotherEnemy.isDestroyed() || enemy.isDestroyed()) {
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
                System.out.println("collided!!!! enemy with enemy");
                enemy.setOppositeDirection();
                anotherEnemy.setOppositeDirection();
            }
        }
    }

    public int weaponCollision(Weapon weapon, Enemy[] enemies) {
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

    public void playerEnemyCollision(Player player, Enemy[] enemies){

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
                player.hit(enemy.getPower());

            }
        }

    }

    /**
     * @TODO add verification and arguments for both towers
     * @param player
     */
    public void reloadSite(Player player ) {


        int playerX = player.getPosition().getX();
        int playerXWidth = playerX + player.getPosition().getWidth();
        int playerY = player.getPosition().getY();
        int playerYHeight = playerY + player.getPosition().getHeight();



            if (    !hasReloaded &&
                    playerX <= 630 &&
                    playerXWidth >= 550 &&
                    playerY <= 400 &&
                    playerYHeight >= 350
            ) {
                System.out.println("Recarregar torre de belém");
                player.reload(WeaponType.PASTEL_DE_BELEM);

                hasReloaded = true;
            }  else if ( !hasReloaded &&
                        playerX <= 220 &&
                        playerXWidth >= 160 &&
                        playerY <= 180 &&
                        playerYHeight >= 130
            ) {
                System.out.println("Recarregar torre dos clérigos");
                player.reload(WeaponType.FRANCESINHA);

                hasReloaded = true;
            } else if(
                    !(playerX <= 630 &&
                    playerXWidth >= 550 &&
                    playerY <= 400 &&
                    playerYHeight >= 350)
                    &&
                    !(
                    playerX <= 220 &&
                    playerXWidth >= 160 &&
                    playerY <= 180 &&
                    playerYHeight >= 130
                    )
            ){
                hasReloaded = false;
            }

        }
    }
