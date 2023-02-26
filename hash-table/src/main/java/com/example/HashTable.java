package com.example;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        // Find where we have to insert a key value pair
        var index = hash(key);

        // If index is null means no entry is present then we need to initialize the linked list and then insert the entry object
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        }

        // Check if key already exists
        // If yes, replace it with our new value
        var bucket = entries[index];
        for (var entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // If key is not found then simply add the key value pair at the end of linked list
        bucket.addLast(new Entry(key, value));
    }

    public String get(int key) {
        var index = hash(key);
        var bucket = entries[index];

        // If linked list is not present at specified index
        if (bucket != null) {

            // Iterate each entry inside linked list and see if matching key is found
            // If matching key is found then return the corresponding value
            for (var entry : bucket) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }

        // No keys are found then return null
        return null;
    }

    public void remove(int key) {
        var index = hash(key);
        var bucket = entries[index];

        if (bucket == null) {
            throw new IllegalStateException();
        }

        for (var entry : bucket) {
            if (entry.key == key) {
                bucket.remove(entry);
                return;
            }
        }

        // We could not find entry with the specified key in bucket
        throw new IllegalStateException();
    }

    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "entries=" + Arrays.toString(entries) +
                '}';
    }
}
