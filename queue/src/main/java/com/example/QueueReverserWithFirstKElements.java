package com.example;

import java.util.Queue;
import java.util.Stack;

/**
 * The type Queue reverser with first k elements.
 * <p>
 * Given an integer K and a queue of integers, write code to reverse the order of the first K elements of the queue.
 */
public class QueueReverserWithFirstKElements {

    /**
     * Reverse.
     *
     * @param queue the queue
     * @param k     the number of first k elements to reverse
     */
    public void reverse(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size())
            throw new IllegalArgumentException();

        Stack<Integer> stack = new Stack<>();

        // Dequeue the first K elements from the queue and push them onto the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        // Enqueue the content of the stack at the back of the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Add the remaining items in the queue (items after the first K elements) to the back of the
        // queue and remove them from the beginning of the queue
        for (int j = 0; j < queue.size() - k; j++) {
            queue.add(queue.remove());
        }

    }
}
