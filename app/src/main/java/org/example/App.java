package org.example;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    FuzzyListGenerator generator = new FuzzyListGenerator();
    FuzzyFinder finder = new FuzzyFinder();

    // test 1: Large sorted list from generator
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    int t1 = finder.linearSearch(sortedFuzzies);
    int t2 = finder.binarySearch(sortedFuzzies);

    System.out.println("TEST 1 - Sorted (7000+ fuzzies)");
    System.out.println("Linear Search Index: " + t1);
    System.out.println("Binary Search Index: " + t2);
    System.out.println();

    // test 2: Large randomized list from generator
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
    int t3 = finder.linearSearch(randomFuzzies);
    int t4 = finder.binarySearch(randomFuzzies); // not guaranteed to work

    System.out.println("TEST 2 - Randomized (7000+ fuzzies)");
    System.out.println("Linear Search Index: " + t3);
    System.out.println("Binary Search Index (likely incorrect): " + t4);
    System.out.println();

    // test 3: Small sorted list with gold in middle
    ArrayList<Fuzzy> smallSorted = new ArrayList<>();
    smallSorted.add(new Fuzzy("blue"));
    smallSorted.add(new Fuzzy("green"));
    smallSorted.add(new Fuzzy("gold")); // middle
    smallSorted.add(new Fuzzy("indigo"));
    smallSorted.add(new Fuzzy("violet"));

    int t5 = finder.linearSearch(smallSorted);
    int t6 = finder.binarySearch(smallSorted);

    System.out.println("TEST 3 - Small Sorted List (gold in middle)");
    System.out.println("Linear Search Index: " + t5);
    System.out.println("Binary Search Index: " + t6);
    System.out.println();

    // test 4: Small sorted list with gold at beginning
    ArrayList<Fuzzy> sortedStart = new ArrayList<>();
    sortedStart.add(new Fuzzy("gold")); // beginning
    sortedStart.add(new Fuzzy("orange"));
    sortedStart.add(new Fuzzy("yellow"));

    int t7 = finder.linearSearch(sortedStart);
    int t8 = finder.binarySearch(sortedStart);

    System.out.println("TEST 4 - Small Sorted List (gold at beginning)");
    System.out.println("Linear Search Index: " + t7);
    System.out.println("Binary Search Index: " + t8);
    System.out.println();

    // test 5: Small sorted list with gold at end
    ArrayList<Fuzzy> sortedEnd = new ArrayList<>();
    sortedEnd.add(new Fuzzy("blue"));
    sortedEnd.add(new Fuzzy("green"));
    sortedEnd.add(new Fuzzy("gold")); // last

    int t9 = finder.linearSearch(sortedEnd);
    int t10 = finder.binarySearch(sortedEnd);

    System.out.println("TEST 5 - Small Sorted List (gold at end)");
    System.out.println("Linear Search Index: " + t9);
    System.out.println("Binary Search Index: " + t10);
    System.out.println();

    // test 6: Small randomized list with gold somewhere
    ArrayList<Fuzzy> smallRandom = new ArrayList<>();
    smallRandom.add(new Fuzzy("violet"));
    smallRandom.add(new Fuzzy("gold")); // random
    smallRandom.add(new Fuzzy("blue"));
    smallRandom.add(new Fuzzy("green"));

    int t11 = finder.linearSearch(smallRandom);
    int t12 = finder.binarySearch(smallRandom); // likely incorrect

    System.out.println("TEST 6 - Small Randomized List");
    System.out.println("Linear Search Index: " + t11);
    System.out.println("Binary Search Index (likely incorrect): " + t12);
    System.out.println();

    // test 7: Gold fuzzy not present
    ArrayList<Fuzzy> noGold = new ArrayList<>();
    noGold.add(new Fuzzy("red"));
    noGold.add(new Fuzzy("orange"));
    noGold.add(new Fuzzy("blue"));

    int t13 = finder.linearSearch(noGold);
    int t14 = finder.binarySearch(noGold);

    System.out.println("TEST 7 - No Golden Fuzzy");
    System.out.println("Linear Search Index (should be -1): " + t13);
    System.out.println("Binary Search Index (should be -1): " + t14);
    System.out.println();

    // test 8: Empty list
    ArrayList<Fuzzy> empty = new ArrayList<>();

    int t15 = finder.linearSearch(empty);
    int t16 = finder.binarySearch(empty);

    System.out.println("TEST 8 - Empty List");
    System.out.println("Linear Search Index (should be -1): " + t15);
    System.out.println("Binary Search Index (should be -1): " + t16);
    System.out.println();
  }
}
