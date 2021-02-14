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


        textScore = new Text(50,120,objectScore.toString());
        textScore.grow(20, 30);
        textWaves = new Text(50, 340, waveCount.toString());
        textWaves.grow(20, 30);
        textPlayerLives = new Text(720, 120, playerLives.toString());
        textPlayerLives.grow(20, 30);
        textAmmo = new Text(720, 340, availableAmmo.toString());
        textAmmo.grow(20, 30);

        menuScreenRect = new Picture(x, y, GameObjectsProperties.FIRST_SCREEN_IMG);
        gameOverPicture = new Picture(x,y, GameObjectsProperties.GAMEOVER_IMG);

    }



    /*public void displayScore(int score) {
        objectScore = score;
        textScore.setText(objectScore.toString());
        textScore.draw();
    }*/

    public void createLivesPic(){
        Picture life1 = new Picture(Dimensions.getMapWidth() + 15, 80, "lives/Choriçosmall.png");
        Picture life2 = new Picture(Dimensions.getMapWidth() + 65, 80, "lives/Choriçosmall.png");
        Picture life3 = new Picture(Dimensions.getMapWidth() + 15, 130, "lives/Choriçosmall.png");
        Picture life4 = new Picture(Dimensions.getMapWidth() + 65, 130, "lives/Choriçosmall.png");
        Picture life5 = new Picture(Dimensions.getMapWidth() + 15, 180, "lives/Choriçosmall.png");
        Picture life6 = new Picture(Dimensions.getMapWidth() + 65, 180, "lives/Choriçosmall.png");
        livesPics = new Picture[]{life1, life2, life3, life4, life5, life6};

        for(Picture pic : livesPics){
            pic.draw();
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
        textScore.draw();

        textWaves.setText(waveCount.toString());
        textWaves.draw();

        /*this.playerLives = playerLives;

        textPlayerLives.setText(this.playerLives.toString());
        textPlayerLives.draw();*/
        if(this.playerLives > playerLives) {
            this.playerLives = playerLives;
            livesPics[playerLives].load("lives/ChoriçoBrancosmall.png");
            livesPics[playerLives].draw();
            //@TODO: change picture to empty choriço
        }

        this.availableAmmo = availableAmmo;
        textAmmo.setText(this.availableAmmo.toString());
        textAmmo.draw();
    }

    public int getWaveCount(){
        return waveCount;
    }
}
