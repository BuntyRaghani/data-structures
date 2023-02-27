package com.example;


import java.util.HashSet;
import java.util.Set;

/**
 * The type Unique pairs finder.
 * Given an array of integers, count the number of unique pairs of integers that have difference k.
 * <p>
 * Input: [1, 7, 5, 9, 2, 12, 3] K=2
 * Output: 4
 * <p>
 * We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9).
 * Note that we only want the number of these pairs, not the pairs themselves.
 */
public class UniquePairsFinder {

    // Time complexity of this method is O(n)
    public int countPairsWithDifference(int[] numbers, int difference) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        // For a given number (a) and difference (diff), number (b) can be:
        //
        // b = a + diff
        // b = a - diff
        //
        // We can iterate over our array of numbers, and for each number,
        // check to see if we have (current + diff) or (current - diff).
        // But looking up items in an array is an O(n) operation. With this
        // algorithm, we need two nested loops (one to pick a,
        // and the other to find b). This will be an O(n^2) operation.
        //
        // We can optimize this by using a set. Sets are like hash tables
        // but they only store keys. We can look up a number in constant time.
        // No need to iterate the array to find it.

        // So, we start by adding all the numbers to a set for quick look up.
        Set<Integer> set = new HashSet<>();
        for (var number : numbers) {
            set.add(number);
        }

        // Now, we iterate over the array of numbers one more time,
        // and for each number check to see if we have (a + diff) or
        // (a - diff) in our set.
        //
        // Once we're done, we should remove this number from our set
        // so we don't double count it.
        var count = 0;
        for (var number : numbers) {
            if (set.contains(number + difference) || set.contains(number - difference)) {
                count++;
            }
            set.remove(number);
        }

        return count;
    }
}
