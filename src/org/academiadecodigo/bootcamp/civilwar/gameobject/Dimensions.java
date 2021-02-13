package org.academiadecodigo.bootcamp.civilwar.gameobject;

public class Dimensions {

    /*private static int screenWidth = 900;
    private static final int screenHeight = 600;*/
    private static int mapWidth = 800-120;
    private static int mapHeight = 450;
    private static int xMap = 120;
    private static int yMap = 0;
    private static final int PADDING = 0;

    public static int getMapWidth(){
        return mapWidth;
    }

    public static int getMapHeight(){
        return mapHeight;
    }

    public static int getXMap(){
        return xMap;
    }

    public static int getYMap(){
        return yMap;
    }

    public static int getRightEdge(){
        return mapWidth;
    }

    public static int getBottomEdge(){
        return mapHeight;
    }
/*
    public static int getScreenWidth(){return screenWidth;}

    public static int getScreenHeight(){return screenHeight;}*/

}
