package org.academiadecodigo.bootcamp.civilwar.gameobject.objinterface;


public interface Destroyable {

    public boolean isDestroyed();

    public void hit(int damage);

}