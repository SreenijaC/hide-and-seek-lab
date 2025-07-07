package org.example;

import java.util.ArrayList;

public class FuzzyFinder {

    // linear search for golden fuzzy among Fuzzy objects
    public int linearSearch(ArrayList<Fuzzy> fuzzies) {
        for (int i = 0; i < fuzzies.size(); i++) {
            if (fuzzies.get(i).color.equals("gold")) {
                return i;
            }
        }
        return -1;
    }

    // binary search for golden fuzzy among Fuzzy objects (list must be sorted)
    public int binarySearch(ArrayList<Fuzzy> fuzzies) {
        int left = 0;
        int right = fuzzies.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midColor = fuzzies.get(mid).color;

            int comparison = midColor.compareTo("gold");

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // linear search to find cold prickly ("pokey!") in feelings list
    public int findColdPricklyIndex(ArrayList<Feeling> feelings) {
        for (int i = 0; i < feelings.size(); i++) {
            if (feelings.get(i).description().equals("pokey!")) {
                return i;
            }
        }
        return -1;
    }
}

/*
 * Add-On: linear search analysis:
 * linear search analysis:
 * 
 * in the worst case, linear search checks every fuzzy in the list before
 * finding the golden one or giving up.
 * if the list has n fuzzies, it will make n checks.
 * 
 * this means the time it takes grows linearly with the size of the list.
 * 
 * we can write this as:
 * T(n) = c * n + d
 * where c and d are constants.
 * 
 * so, linear search runs in O(n) time.
 * 
 * 
 * Add-On: binary search analysis:
 * binary search works only on sorted lists. it keeps cutting the list in half
 * to find the golden fuzzy.
 * 
 * in the worst case, it keeps splitting until just one fuzzy is left.
 * 
 * this means it makes about log2(n) comparisons for a list of size n.
 * 
 * we can write this as:
 * T(n) = c * log2(n) + d
 * where c and d are constants.
 * 
 * so, binary search runs in O(log n) time, which is way faster than linear
 * search for big lists.
 */
