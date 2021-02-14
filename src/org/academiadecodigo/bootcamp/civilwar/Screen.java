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

    private void createLivesPic(){

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

        this.playerLives = playerLives;
        textPlayerLives.setText(this.playerLives.toString());
        textPlayerLives.draw();

        this.availableAmmo = availableAmmo;
        textAmmo.setText(this.availableAmmo.toString());
        textAmmo.draw();
    }

    public int getWaveCount(){
        return waveCount;
    }
}
