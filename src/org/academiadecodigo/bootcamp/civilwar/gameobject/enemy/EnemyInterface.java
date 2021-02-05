package org.academiadecodigo.bootcamp.civilwar.gameobject.enemy;

import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;

public interface EnemyInterface {

    void move();

    Direction chooseDirection();

}
