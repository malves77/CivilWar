package org.academiadecodigo.bootcamp.civilwar.gameobject.enemy;

import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;

public interface EnemyInterface {

    void move();

    Direction chooseDirection();

}
