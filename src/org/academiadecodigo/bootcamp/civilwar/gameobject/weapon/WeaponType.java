package org.academiadecodigo.bootcamp.civilwar.gameobject.weapon;

public enum WeaponType {
    FRANCESINHA(3),
    VINHO_DO_PORTO(5),
    PASTEL_DE_BELEM(3),
    GINGINHA(5);

    private int damage;

    WeaponType(int damage) {
        this.damage = damage;
    }
}
