package com.example;

import java.util.Arrays;

/**
 * The type Priority queue.
 * <p>
 * Implement priority queue using an array
 */
public class PriorityQueue {

    private int[] items = new int[5];
    private int count;

    /**
     * Add a new item.
     *
     * @param item the item
     */
    public void add(int item) {

        if (isFull()) {
            throw new IllegalStateException();
        }
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                // we are done with shifting elements, break loop and perform the insertion
                break;
            }
        }
        return i + 1;
    }

    /**
     * Remove an item.
     * Instead of removing an item from front of our queue let say our priority is to remove it from back
     *
     * @return the int
     */
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        count = count - 1;
        return items[count];
    }

    /**
     * Is empty.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Is full.
     *
     * @return the boolean
     */
    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
