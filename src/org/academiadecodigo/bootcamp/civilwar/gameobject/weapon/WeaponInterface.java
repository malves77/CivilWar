package org.academiadecodigo.bootcamp.civilwar.gameobject.weapon;

import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Direction;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;

public interface WeaponInterface {

    void move(Position pos, Direction direction);

    

}