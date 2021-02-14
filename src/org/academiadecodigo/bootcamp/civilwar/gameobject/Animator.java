package org.academiadecodigo.bootcamp.civilwar.gameobject;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Animator {

    private String rootPath;
    private int frameTime;
    private int index;
    private Picture frame;


    public Animator(int x, int y, String rootPath){
        this.rootPath = rootPath;
        this.frameTime = 40;
        this.index = 1;
        this.frame = new Picture(x, y, rootPath + "/runDown/1.png");
    }

    public String /* Picture */animate(String path){

        //System.out.println("animating");

        index++;
        if(index >= 22){
            index = 1;
        }
        return rootPath + "/" + path + "/" + index + ".png";
    }
}
