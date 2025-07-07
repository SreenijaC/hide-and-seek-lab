package org.example;

// Don't change this file!

public class Fuzzy implements Feeling {
    public String color;

    public Fuzzy(String color) {
        this.color = color;
    }

    @Override
    public String description() {
        return color;
    }
}

