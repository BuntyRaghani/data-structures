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

        HashTable hashTable = new HashTable();
        hashTable.put(6, "A"); // Will be stored at index 1
        hashTable.put(8, "B"); // Will be stored at index 3
        hashTable.put(11, "C"); // Will be stored at index 1 (at end of linked list)
        System.out.println("Hash table after inserting 3 key value pairs: " + hashTable);

        hashTable.put(6, "A+");
        System.out.println("Hash table after adding duplicate key: " + hashTable);

        System.out.println("Value associated with key 6 is " + hashTable.get(6)); // A+
        System.out.println("Value associated with key 10 is " + hashTable.get(10)); // null - key 10 does not exist

        hashTable.remove(6);
        System.out.println("Hash table after entry with key 6: " + hashTable);

        //hashTable.remove(10);
        // will throw IllegalStateException. Linked list was null at specified index. Also, we don't have any entry with key 10
        //hashTable.remove(16);
        // will throw IllegalStateException. Linked list was not null but key 16 does not exist

        System.out.println("\n\n\nMost Repeated Element Finder");
        int[] inputArray = new int[]{1, 2, 2, 3, 3, 3, 4};
        MostRepeatedElementFinder mostRepeatedElementFinder = new MostRepeatedElementFinder();
        System.out.println("Most Repeated Element: " + mostRepeatedElementFinder.mostFrequent(inputArray));
    }


}
