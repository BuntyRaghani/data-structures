package com.example;

import java.util.Arrays;

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
        System.out.println("Hash table after removing entry with key 6: " + hashTable);

        //hashTable.remove(10);
        // will throw IllegalStateException. Linked list was null at specified index. Also, we don't have any entry with key 10
        //hashTable.remove(16);
        // will throw IllegalStateException. Linked list was not null but key 16 does not exist

        System.out.println("\n\n\nMost Repeated Element Finder");
        int[] inputArray = new int[]{1, 2, 2, 3, 3, 3, 4};
        MostRepeatedElementFinder mostRepeatedElementFinder = new MostRepeatedElementFinder();
        System.out.println("Most Repeated Element: " + mostRepeatedElementFinder.mostFrequent(inputArray));

        System.out.println("\n\n\nTwo Sum Index Finder");
        int[] twoSumIndexFinderInputArray = new int[]{2, 11, 7, 15};
        int target = 9;
        TwoSumIndexFinder twoSumIndexFinder = new TwoSumIndexFinder();
        System.out.println("Indexes of elements adding up to target " + target + " are " + Arrays.toString(twoSumIndexFinder.twoSum(twoSumIndexFinderInputArray, target)));


        System.out.println("\n\n\n Hash Table With Linear Probing");
        HashTableLinearProbing hashTableLinearProbing = new HashTableLinearProbing();
        hashTableLinearProbing.put(6, "A");
        hashTableLinearProbing.put(8, "B");
        hashTableLinearProbing.put(11, "C");
        System.out.println("Hash table after inserting 3 key value pairs: " + hashTableLinearProbing);

        hashTableLinearProbing.put(6, "A+");
        System.out.println("Hash table after adding duplicate key: " + hashTableLinearProbing);

        System.out.println("Value associated with key 6 is " + hashTableLinearProbing.get(6));
        System.out.println("Value associated with key 10 is " + hashTableLinearProbing.get(10));

        hashTableLinearProbing.remove(6);
        System.out.println("Hash table after removing entry with key 6: " + hashTableLinearProbing);
    }

}
