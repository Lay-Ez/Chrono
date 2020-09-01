package com.company;

public class SecondsPrinter implements Runnable {

    private final Chrono chrono;
    private final int step;

    public SecondsPrinter(Chrono chrono, int step) {
        this.chrono = chrono;
        this.step = step;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (chrono.lock) {
                try {
                    chrono.lock.wait();
                } catch (InterruptedException e) {}
                System.out.println("Seconds passed: " + chrono.getSecondsPassed());
            }

        }
    }
}
