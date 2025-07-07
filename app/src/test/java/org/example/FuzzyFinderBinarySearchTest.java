package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class FuzzyFinderBinarySearchTest {

    FuzzyFinder finder = new FuzzyFinder();
    FuzzyListGenerator generator = new FuzzyListGenerator();

    @Test
    void binarySearchFindsGoldInLargeSortedList() {
        ArrayList<Fuzzy> sorted = generator.sortedRainbowFuzzies();
        int index = finder.binarySearch(sorted);
        assertTrue(index >= 0);
        assertEquals("gold", sorted.get(index).color);
    }

    @Test
    void binarySearchReturnsMinusOneWhenNoGold() {
        ArrayList<Fuzzy> noGold = new ArrayList<>();
        noGold.add(new Fuzzy("red"));
        noGold.add(new Fuzzy("orange"));
        noGold.add(new Fuzzy("blue"));
        assertEquals(-1, finder.binarySearch(noGold));
    }

    @Test
    void binarySearchReturnsMinusOneWhenEmpty() {
        ArrayList<Fuzzy> empty = new ArrayList<>();
        assertEquals(-1, finder.binarySearch(empty));
    }
}
