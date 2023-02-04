package com.example;


/**
 * The type Min stack.
 * <p>
 * Problem:
 * Design a stack that supports push, pop and retrieving the minimum value in a constant time.
 * <p>
 * Solution:
 * We will have to create two stacks.
 * First stack will hold all the values and second stack will hold only the minimum values.
 * The impact of push and pop operation will be on both the stacks.
 * The minimum value can be returned from top of the second stack
 */
public class MinStack {

    private Stack stack = new Stack();
    private Stack minStack = new Stack();

    /**
     * Push an item into the stack.
     * Also, check if the input item is less than the peek item which is present on min stack.
     * if yes, push the same item in the min stack as well.
     *
     * @param item the item
     */
    public void push(int item) {
        stack.push(item);

        if (minStack.isEmpty() || item < minStack.peek()) {
            minStack.push(item);
        }
    }

    /**
     * Pop an item from the stack.
     * Also, check if the popped item is equal to the peek item which is present on min stack.
     * if yes, pop an item from the min stack as well.
     *
     * @return the int
     */
    public int pop() {
        int top = stack.pop();

        if (minStack.peek() == top) {
            minStack.pop();
        }
        return top;
    }

    /**
     * Min item.
     * Return the peek element from the min stack.
     * Peek element in the min stack will always be the smallest number.
     *
     * @return the int
     */
    public int min() {
        return minStack.peek();
    }


    /**
     * Print the current state of min stack.
     */
    public String printMinStack() {
        return stack.toString();
    }
}
