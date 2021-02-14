package org.academiadecodigo.bootcamp.civilwar.gameobject.weapon;

public enum WeaponType {
    FRANCESINHA(3, "images/weapon/francesinha.png"),
    //VINHO_DO_PORTO(5),
    PASTEL_DE_BELEM(3, "images/weapon/pastelbelem.png");
    //GINGINHA(5);

    private int damage;
    private String imgPath;

    WeaponType(int damage, String imgPath) {
        this.damage = damage;
        this.imgPath = imgPath;
    }

    public int getDamage() {
        return damage;
    }

    public String getImgPath(){
        return imgPath;
    }
}
