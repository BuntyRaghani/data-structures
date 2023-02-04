package com.example;

import java.util.Arrays;

/**
 * The type Two stacks.
 * <p>
 * Implement two stacks in one array that supports:
 * push1() - push in the first stack
 * push2() - push in the second stack
 * pop1() - pop from the first stack
 * pop2() - pop from the second stack
 * isEmpty1() - to check if the first stack is empty
 * isEmpty2() - to check if the second stack is empty
 * isFull1() - to check if the first stack is full
 * isFull2() - to check if the second stack is full
 * <p>
 * Note: Do not allocate the same amount of space by dividing the array in half.
 */
public class TwoStacks {

    private int[] items;
    private int top1;
    private int top2;

    /**
     * Initialize an array and top of two stacks.
     *
     * @param capacity the capacity
     */
    TwoStacks(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than or equal to 1");
        }

        items = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    /**
     * Is stack 1 full
     *
     * @return the boolean
     */
    public boolean isFull1() {
        return top1 + 1 == top2;
    }

    /**
     * Is stack 2 full
     *
     * @return the boolean
     */
    public boolean isFull2() {
        return top2 - 1 == top1;
    }

    /**
     * Is stack 1 empty
     *
     * @return the boolean
     */
    public boolean isEmpty1() {
        return top1 == -1;
    }

    /**
     * Is stack 2 empty
     *
     * @return the boolean
     */
    public boolean isEmpty2() {
        return top2 == items.length;
    }

    /**
     * Push an item in the first stack
     *
     * @param item the item
     */
    public void push1(int item) {
        if (isFull1()) {
            throw new StackOverflowError();
        }
        top1 = top1 + 1;
        items[top1] = item;
    }

    /**
     * Push an item in the second stack.
     *
     * @param item the item
     */
    public void push2(int item) {
        if (isFull2()) {
            throw new StackOverflowError();
        }
        top2 = top2 - 1;
        items[top2] = item;
    }

    /**
     * Push an item from the first stack.
     *
     * @return the int
     */
    public int pop1() {
        if (isEmpty1()) {
            throw new IllegalStateException();
        }
        int topElement = items[top1];
        top1 = top1 - 1;
        return topElement;
    }

    /**
     * Push an item from the second stack.
     *
     * @return the int
     */
    public int pop2() {
        if (isEmpty2()) {
            throw new IllegalStateException();
        }
        int topElement = items[top2];
        top2 = top2 + 1;
        return topElement;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
