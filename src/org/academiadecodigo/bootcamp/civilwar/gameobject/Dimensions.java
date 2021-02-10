package org.academiadecodigo.bootcamp.civilwar.gameobject;

public class Dimensions {

    private static int mapWidth = 600;
    private static int mapHeight = 600;
    private static final int PADDING = 20;
    private static int xMap = 100;
    private static int yMap = 0;

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
        return getXMap() + getMapWidth();
    }

    public static int getBottomEdge(){
        return getYMap() + getMapHeight();
    }
}
