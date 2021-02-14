package org.academiadecodigo.bootcamp.civilwar.gameobject.enemy;

import org.academiadecodigo.bootcamp.civilwar.Randomizer;

public enum EnemyType {

    ENEMY("images/tourist"),
    ROB("images/tourist/rob"),
    CHRIS("images/tourist/chris"),
    RAC("images/tourist/rac");

    private String pathToFolder;

    EnemyType(String pathToFolder){
        this.pathToFolder = pathToFolder;
    }

    public String getPathToFolder(){
        return pathToFolder;
    }

    public EnemyType getRandomEnemy(){
        int value = Randomizer.getRandomWithMax(100);
        System.out.println("value is: " + value);
        if(value < 76){

            return EnemyType.ENEMY;
        } else if(value < 84){
            return EnemyType.ROB;
        } else if(value < 92){
            return EnemyType.CHRIS;
        } else {
            return EnemyType.RAC;
        }

    }

}
