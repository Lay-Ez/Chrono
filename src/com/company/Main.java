package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Chrono chrono = new Chrono(1);
        SecondsPrinter secondsPrinter = new SecondsPrinter(chrono, 1);
        List<String> words = new ArrayList<>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        WordsPrinter wordsPrinter = new WordsPrinter(words, 5, chrono);
        WordsPrinter wordsPrinter2 = new WordsPrinter(words, 7, chrono);

        new Thread(chrono).start();
        new Thread(secondsPrinter).start();
        new Thread(wordsPrinter).start();
        new Thread(wordsPrinter2).start();
    }
}
