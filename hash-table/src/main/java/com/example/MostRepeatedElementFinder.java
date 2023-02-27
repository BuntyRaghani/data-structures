package com.example;


import java.util.HashMap;
import java.util.Map;

/**
 * The type Most repeated element finder.
 * <p>
 * Find the most repeated element in an array of integers.
 * What is the time complexity of this method?
 */
public class MostRepeatedElementFinder {

    // Runtime complexity of this method is O(n) because we have to
    // iterate the entire array to populate our hash table.
    public int mostFrequent(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        // To find the most frequent item in an array, we have to count the
        // number of times each item has been repeated. We can use a hash
        // table to store the items and their frequencies.
        Map<Integer, Integer> map = new HashMap<>();
        for (var number : numbers) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        // Once we've populated our hash table, we need to iterate over all
        // key/value pairs and find the one with the highest frequency.
        int max = -1;
        int result = numbers[0];
        for (var entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
