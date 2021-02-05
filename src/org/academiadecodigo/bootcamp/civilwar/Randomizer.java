package org.academiadecodigo.bootcamp.civilwar;

public class Randomizer {

    public static int getRandomInRange(int max) {
        return (int)(Math.random() * max + 1);
    }

}
