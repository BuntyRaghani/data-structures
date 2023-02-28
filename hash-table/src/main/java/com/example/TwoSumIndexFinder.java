package com.example;


import java.util.HashMap;
import java.util.Map;

/**
 * The type Two sum index finder.
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * Input: [2, 11, 7, 15] - target = 9
 * Output: [0, 2] (because 2 + 7 = 9)
 * <p>
 * Assume that each input has exactly one solution, and you may not use the same element twice
 */
public class TwoSumIndexFinder {

    // Time complexity of this method is O(n) because we need to iterate the array only once.
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        // This problem is a variation of the problem countPairsWithDiff.
        //
        // If a + b = target, then b = target - a.
        //
        // So we iterate our array, and pick (a). Then,
        // we check to see if we have (b) in our array.
        // Similar to the countPairsWithDiff problem, this would be an O(n^2)
        // operation, because we'll need two nested loops for
        // looking up (b).
        //
        // We can optimize this by using a hash table. In this
        // hash table, we store numbers and their indexes.
        //
        // There is no need to store all the numbers in the hash table
        // first. If we find two numbers that add up to the target,
        // we simply return their indexes.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}
