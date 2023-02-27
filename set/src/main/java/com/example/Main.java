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

        System.out.println("\n\n\nUnique Pairs Finder");
        int[] uniquePairsFinderInputArray = new int[]{1, 7, 5, 9, 2, 12, 3};
        int difference = 2;
        UniquePairsFinder uniquePairsFinder = new UniquePairsFinder();
        System.out.println("Number of unique pairs with difference " + difference + " are " + uniquePairsFinder.countPairsWithDifference(uniquePairsFinderInputArray, difference));
    }

}
