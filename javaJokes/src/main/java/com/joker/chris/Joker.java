package com.joker.chris;

import java.util.Random;

public class Joker {
    private static final String[] jokes = {
            "A fragment walks into a bar, and the bartender asks for an ID. Fragment says, \"I don’t have an ID.\" So the bartender says, \"Okay, I’ll make a NullPointerException.\"",
            "What is the difference between Android 2.1 and 2.2?\n 6 months",
            "A Samsung Galaxy S7 walks into a bar. The bartender says, " +
                    "\"Look buddy, I don't want any trouble — just take the money and get out of here.\"\n" +
                    "The Android looked up, a bit puzzled, and then exploded.",
            "A pregnant fragment walks into a bar. The bartender says, \"Whoa! Whoa! We don't support nested fragments here!\""
    };

    public static String getRandomJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}
