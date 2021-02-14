package org.academiadecodigo.bootcamp.civilwar;

import org.academiadecodigo.bootcamp.civilwar.gameobject.Dimensions;
import org.academiadecodigo.bootcamp.civilwar.gameobject.GameObjectsProperties;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {
    private int x;
    private int y;
    private int padding;
    private int width;
    private int height;
    private Rectangle rect;
    private Integer objectScore;
    private Text textScore;
    private Integer waveCount;
    private Text textWaves;
    private Integer playerLives;
    private Text textPlayerLives;
    private Integer availableAmmo;
    private Text textAmmo;
    private Picture[] ammoPics;
    private Picture[] livesPics;

    private Picture menuScreenRect;
    private Picture gameOverPicture;

    public Screen(){
        x = 0;
        y = 0;
        padding = 10;

        objectScore = 0;
        waveCount = 1;
        playerLives = GameObjectsProperties.PLAYER_HEALTH;
        availableAmmo = GameObjectsProperties.TOTAL_WEAPONS;
        ammoPics = new Picture[availableAmmo];


        textScore = new Text(55,120,objectScore.toString());
        textScore.grow(20, 30);
        textWaves = new Text(60, 340, waveCount.toString());
        textWaves.grow(20, 30);


        menuScreenRect = new Picture(x, y, GameObjectsProperties.FIRST_SCREEN_IMG);
        gameOverPicture = new Picture(x,y, GameObjectsProperties.GAMEOVER_IMG);

    }

    public void createLivesPic(){
        Picture life1 = new Picture(Dimensions.getMapWidth() + 15, 80, "images/lives/Choriçosmall.png");
        Picture life2 = new Picture(Dimensions.getMapWidth() + 65, 80, "images/lives/Choriçosmall.png");
        Picture life3 = new Picture(Dimensions.getMapWidth() + 15, 130, "images/lives/Choriçosmall.png");
        Picture life4 = new Picture(Dimensions.getMapWidth() + 65, 130, "images/lives/Choriçosmall.png");
        Picture life5 = new Picture(Dimensions.getMapWidth() + 15, 180, "images/lives/Choriçosmall.png");
        Picture life6 = new Picture(Dimensions.getMapWidth() + 65, 180, "images/lives/Choriçosmall.png");
        livesPics = new Picture[]{life1, life2, life3, life4, life5, life6};

        for(Picture pic : livesPics){
            pic.draw();
        }

    }

    public void createAmmoPics(){

        int originX = Dimensions.getMapWidth() + 40;
        int originY = 280;
        int ammoX = originX + 13;


        Picture container = new Picture(originX, originY, "images/ammo/ammocontainer.png");
        container.draw();

        ammoPics[0] = new Picture(ammoX, originY + 15, "images/ammo/ammo0.png" );
        ammoPics[0].draw();
        for(int i = 1; i < ammoPics.length; i++){
            ammoPics[i] = new Picture(ammoX, ammoPics[i-1].getY() + ammoPics[i-1].getHeight() + 4, "images/ammo/ammo" + i + ".png");
            ammoPics[i].draw();
        }


    }

    public void displayMenu() {
        System.out.println("Called displayMenu!");
        menuScreenRect.draw();
        //can Animate up
    }

    public void removeMenu() {
        System.out.println("Removing Menu");
        menuScreenRect.delete();
    }

    public void displayGameOver(){
        gameOverPicture.draw();
    }

    public void updateWave(){
        waveCount++;
    }

    public void updateInterface(int playerScore, int playerLives, int availableAmmo) {
        objectScore = playerScore;
        textScore.setText(objectScore.toString());
        textScore.setColor(Color.WHITE);
        textScore.draw();

        textWaves.setText(waveCount.toString());
        textWaves.setColor(Color.WHITE);
        textWaves.draw();

        if(this.playerLives > playerLives) {
            this.playerLives = playerLives;
            livesPics[playerLives].load("images/lives/ChoriçoBrancosmall.png");
            livesPics[playerLives].draw();
        }


        if(this.availableAmmo > availableAmmo){
            this.ammoPics[ammoPics.length - availableAmmo - 1].delete();
        }
        this.availableAmmo = availableAmmo;
        if(this.availableAmmo == ammoPics.length) {
            System.out.println("repainting all ammo");
            for(Picture pic : ammoPics){
                pic.draw();
            }
        }

    }

    public int getWaveCount(){
        return waveCount;
    }

    public void firstScreenInterPaint(){
        createAmmoPics();
        createLivesPic();
    }
}
