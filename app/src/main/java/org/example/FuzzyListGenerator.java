package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class FuzzyListGenerator {
  int iterations;

  public FuzzyListGenerator() {
    this.iterations = 1000;
  }

  public FuzzyListGenerator(int iterations) {
    this.iterations = iterations;
  }

  // original methods returning Fuzzy only
  public ArrayList<Fuzzy> randomizedRainbowFuzzies() {
    ArrayList<Fuzzy> fuzzies = new ArrayList<>();
    for (int i = 0; i < this.iterations; i++) {
      fuzzies.add(new Fuzzy("red"));
      fuzzies.add(new Fuzzy("orange"));
      fuzzies.add(new Fuzzy("yellow"));
      fuzzies.add(new Fuzzy("green"));
      fuzzies.add(new Fuzzy("blue"));
      fuzzies.add(new Fuzzy("indigo"));
      fuzzies.add(new Fuzzy("violet"));
    }
    fuzzies.add(new Fuzzy("gold"));

    Collections.shuffle(fuzzies);
    return fuzzies;
  }

  public ArrayList<Fuzzy> sortedRainbowFuzzies() {
    ArrayList<Fuzzy> fuzzies = new ArrayList<>();
    for (int i = 0; i < this.iterations; i++) {
      fuzzies.add(new Fuzzy("red"));
      fuzzies.add(new Fuzzy("orange"));
      fuzzies.add(new Fuzzy("yellow"));
      fuzzies.add(new Fuzzy("green"));
      fuzzies.add(new Fuzzy("blue"));
      fuzzies.add(new Fuzzy("indigo"));
      fuzzies.add(new Fuzzy("violet"));
    }
    fuzzies.add(new Fuzzy("gold"));

    fuzzies.sort((f1, f2) -> f1.color.compareTo(f2.color));
    return fuzzies;
  }

  // new methods returning Feeling list with pricklies for add-ons
  public ArrayList<Feeling> randomizedRainbowFeelings() {
    ArrayList<Feeling> feelings = new ArrayList<>();
    for (int i = 0; i < this.iterations; i++) {
      feelings.add(new Fuzzy("red"));
      feelings.add(new Fuzzy("orange"));
      feelings.add(new Fuzzy("yellow"));
      feelings.add(new Fuzzy("green"));
      feelings.add(new Fuzzy("blue"));
      feelings.add(new Fuzzy("indigo"));
      feelings.add(new Fuzzy("violet"));
    }
    feelings.add(new Fuzzy("gold"));
    feelings.add(new Prickly());

    Collections.shuffle(feelings);
    return feelings;
  }

  public ArrayList<Feeling> sortedRainbowFeelings() {
    ArrayList<Feeling> feelings = new ArrayList<>();
    for (int i = 0; i < this.iterations; i++) {
      feelings.add(new Fuzzy("red"));
      feelings.add(new Fuzzy("orange"));
      feelings.add(new Fuzzy("yellow"));
      feelings.add(new Fuzzy("green"));
      feelings.add(new Fuzzy("blue"));
      feelings.add(new Fuzzy("indigo"));
      feelings.add(new Fuzzy("violet"));
    }
    feelings.add(new Fuzzy("gold"));
    feelings.add(new Prickly());

    feelings.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    return feelings;
  }
}
