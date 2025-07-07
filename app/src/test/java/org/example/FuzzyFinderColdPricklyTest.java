package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class FuzzyFinderColdPricklyTest {

    FuzzyFinder finder = new FuzzyFinder();
    FuzzyListGenerator generator = new FuzzyListGenerator(10);

    @Test
    void findColdPricklyInRandomizedFeelings() {
        ArrayList<Feeling> randomFeelings = generator.randomizedRainbowFeelings(); // <--- changed here
        int index = finder.findColdPricklyIndex(randomFeelings);
        assertTrue(index >= 0, "should find a cold prickly in randomized feelings");
        assertEquals("pokey!", randomFeelings.get(index).description());
    }

    @Test
    void findColdPricklyInSortedFeelings() {
        ArrayList<Feeling> sortedFeelings = generator.sortedRainbowFeelings(); // <--- changed here
        int index = finder.findColdPricklyIndex(sortedFeelings);
        assertTrue(index >= 0, "should find a cold prickly in sorted feelings");
        assertEquals("pokey!", sortedFeelings.get(index).description());
    }

    @Test
    void findColdPricklyReturnsMinusOneWhenNoPrickly() {
        ArrayList<Feeling> list = new ArrayList<>();
        list.add(new Fuzzy("red"));
        list.add(new Fuzzy("blue"));
        int index = finder.findColdPricklyIndex(list);
        assertEquals(-1, index, "should return -1 when no cold prickly");
    }

    @Test
    void findColdPricklyReturnsMinusOneOnEmptyList() {
        ArrayList<Feeling> empty = new ArrayList<>();
        int index = finder.findColdPricklyIndex(empty);
        assertEquals(-1, index, "should return -1 on empty list");
    }
}
