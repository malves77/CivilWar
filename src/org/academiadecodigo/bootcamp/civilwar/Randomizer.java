package org.academiadecodigo.bootcamp.civilwar;

public class Randomizer {

    public static int getRandomWithMax(int max) {
        return (int)(Math.random() * max);
    }

    public static int getRandomInRange(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

}
