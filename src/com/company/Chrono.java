package com.company;

public class Chrono implements Runnable {

    private int secondsPassed = 0;
    private final int periodInSeconds;
    public final Object lock = new Object();

    public Chrono(int periodInSeconds) {
        this.periodInSeconds = periodInSeconds;
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(periodInSeconds * 1000);
                synchronized (this.lock) {
                    secondsPassed++;
                    this.lock.notifyAll();
                }
            } catch (InterruptedException e) {
                System.out.println("Chrono thread was interrupted ");
                e.printStackTrace();
            }
        }
    }
}
