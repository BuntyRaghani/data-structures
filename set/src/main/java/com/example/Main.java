package com.example;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        FirstRepeatingCharFinder firstRepeatingCharFinder = new FirstRepeatingCharFinder();
        char result = firstRepeatingCharFinder.findFirstRepeatingChar("green apple");
        System.out.println("First repeating character: " + result);
    }

}
