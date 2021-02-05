package org.academiadecodigo.bootcamp.civilwar.gameobject;

import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;

public abstract class GameObject {

    private Position myPos;

    public GameObject (Position myPos) {
        this.myPos = myPos;
    }

    void setPosition(Position newPos) {
        myPos = newPos;
    }

    Position getPosition() {
        return myPos;
    }

}
