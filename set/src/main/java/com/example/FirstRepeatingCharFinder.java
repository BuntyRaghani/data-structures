package com.example;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingCharFinder {

    public char findFirstRepeatingChar(String input) {
        Set<Character> set = new HashSet<>();

        for (var ch : input.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            } else {
                set.add(ch);
            }
        }

        // this is returned when every char in a string is repeated
        return Character.MIN_VALUE;
    }
}
