package org.academiadecodigo.bootcamp.civilwar;

public class GameTimer extends Thread{

    private long counter;
    private long maxTime;
    private boolean hasFinished;

    public GameTimer(long maxTime){
        counter = 0;
        this.maxTime = maxTime;
        hasFinished = false;
    }

    public void startCounting() {
        resetCounter();
        long initialTime = System.currentTimeMillis();
        long currentTime;

        while(counter <= maxTime){
            currentTime = System.currentTimeMillis();
            counter += currentTime - initialTime;
            System.out.println(counter);
        }
        hasFinished = true;

    }

    public void resetCounter(){
        counter = 0;
        hasFinished = false;
    }

    @Override
    public void run() {
        System.out.println("running");
    }

    public boolean getFinished(){
        return hasFinished;
    }
}
