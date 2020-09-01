package com.company;

import java.util.List;

public class WordsPrinter implements Runnable {

    private final List<String> words;
    private final int stepInSeconds;
    private final Chrono chrono;

    public WordsPrinter(List<String> words, int stepInSeconds, Chrono chrono) {
        this.words = words;
        this.stepInSeconds = stepInSeconds;
        this.chrono = chrono;
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            synchronized (chrono.lock) {
                try {
                    chrono.lock.wait();
                    if (chrono.getSecondsPassed() % stepInSeconds == 0) {
                        try {
                            System.out.println(words.get(index));
                            index++;
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                } catch (InterruptedException e) {}
            }
        }
    }
}
