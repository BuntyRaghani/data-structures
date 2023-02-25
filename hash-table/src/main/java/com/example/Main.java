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

        FirstNonRepeatingCharFinder firstNonRepeatingCharFinder = new FirstNonRepeatingCharFinder();
        char result = firstNonRepeatingCharFinder.findFirstNonRepeatingChar("a green apple");
        System.out.println("First non repeating character: " + result);
    }


}
