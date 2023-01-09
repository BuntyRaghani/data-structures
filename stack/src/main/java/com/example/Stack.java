package com.example;


import java.util.Arrays;

/**
 * The type Stack.
 * <p>
 * Implementing stack using an array.
 * <p>
 * Implementation approach:
 * Create an array with fixed size and create a count which will keep track of index at which we want to insert the next element.
 * Whenever we will insert a new element, default value will be replaced by our new value and count will be incremented by 1.
 * Whenever we will delete an element, we will just decrement the count value by 1. This will give an illusion of deletion operation.
 */
public class Stack {
    private int[] items = new int[5];
    private int count;

    public void push(int item) {
        if (count == items.length) {
            throw new StackOverflowError();
        }
        items[count] = item;
        count++;
    }

    public int pop() {
        if (count == 0) {
            throw new IllegalStateException();
        }

        count--;
        return items[count];

    }

    public int peek() {
        if (count == 0) {
            throw new IllegalStateException();
        }
        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        // To copy elements from original stack to new stack without 0's
        int[] content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
