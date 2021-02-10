package org.academiadecodigo.bootcamp.civilwar;

//import java.util.TimerTask;

public class GameTimer implements Runnable{

    private Thread currentThread;
    private long counter;
    private long maxTime;
    private boolean hasFinished;

    public GameTimer(long maxTime) {
        counter = 0;
        this.maxTime = maxTime;
        hasFinished = false;
        currentThread = new Thread(this);
    }

    /*
    public void startCounting() {
        resetCounter();
        long initialTime = System.currentTimeMillis();
        long currentTime;

        while (counter <= maxTime) {
            currentTime = System.currentTimeMillis();
            counter += currentTime - initialTime;
            System.out.println(counter);
        }
        hasFinished = true;

    }

    public void resetCounter() {
        counter = 0;
        hasFinished = false;
    }
    */
    @Override
    public void run() {
        this.hasFinished = completeTask(maxTime);
    }

    private boolean completeTask(long maxTime) {
        try {
            currentThread.sleep(maxTime);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean getFinished() {
        return hasFinished;
    }

}
