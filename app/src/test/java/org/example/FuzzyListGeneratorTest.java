package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FuzzyListGeneratorTest {

    @Test
    void randomizedRainbowFuzziesContainsGold() {
        FuzzyListGenerator generator = new FuzzyListGenerator(10);
        ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
        boolean containsGold = fuzzies.stream().anyMatch(f -> f.color.equals("gold"));
        assertTrue(containsGold);
    }

    @Test
    void sortedRainbowFuzziesIsSorted() {
        FuzzyListGenerator generator = new FuzzyListGenerator(10);
        ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
        for (int i = 0; i < fuzzies.size() - 1; i++) {
            String current = fuzzies.get(i).color;
            String next = fuzzies.get(i + 1).color;
            assertTrue(current.compareTo(next) <= 0, "List is sorted ascending");
        }
    }
}
