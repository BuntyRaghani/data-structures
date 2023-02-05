package com.example;

import java.util.Queue;
import java.util.Stack;


/**
 * The type Queue reverser.
 * <p>
 * Reverse a queue using add, remove, and isEmpty methods only.
 */
public class QueueReverser {

    /**
     * Reverse.
     *
     * @param queue the queue
     */
    public void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
