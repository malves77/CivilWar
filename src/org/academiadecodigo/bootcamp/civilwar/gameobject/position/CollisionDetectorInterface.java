package org.academiadecodigo.bootcamp.civilwar.gameobject.position;

import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObject;
import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;

public interface CollisionDetectorInterface {

    void detectCollision(GameObject obj);

    void collides(Position pos);

}
