package com.example;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharFinder {

    public char findFirstNonRepeatingChar(String input) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = input.toCharArray();

        // populate hash map with count for each character
        for (var ch : chars) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (var ch : chars) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        // this is returned when every char in a string is repeated
        return Character.MIN_VALUE;
    }
}
