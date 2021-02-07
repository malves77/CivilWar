package org.academiadecodigo.bootcamp.civilwar.gameobject;

import org.academiadecodigo.bootcamp.civilwar.gameobject.position.Position;

public abstract class GameObject {

    private Position myPos;

    protected GameObject (){}

    protected GameObject (Position myPos) {
        this.myPos = myPos;
    }

    protected void setPosition(Position newPos) {
        myPos = newPos;
    }

    protected Position getPosition() {
        return myPos;
    }

}
