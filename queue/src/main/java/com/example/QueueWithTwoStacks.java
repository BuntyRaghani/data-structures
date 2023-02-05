package com.example;


import java.util.Stack;

/**
 * The type Queue with two stacks.
 * <p>
 * Implement queue using stack
 * <p>
 * Here we will make use of two stacks.
 * Enqueue operation will be performed on the first stack
 * Dequeue operation will be performed on the second stack
 * <p>
 * Whenever second stack is/becomes empty then we will copy the elements from first stack
 */
public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * Insert an element at end of queue.
     *
     * @param item the item
     */
    public void enqueue(int item) {
        stack1.push(item);
    }

    /**
     * Remove element from the front of the queue
     *
     * @return the int
     */
    public int dequeue() {
        // This is to prevent EmptyStack exception when dequeue operation is performed if queue is empty
        // Queue is empty means stack 1 and stack 2 are empty so no copy operation will be performed and pop method will throw an exception
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        moveStack1ToStack2();

        return stack2.pop();
    }

    /**
     * Peek int.
     *
     * @return the int
     */
    public int peek() {
        // This is to prevent EmptyStack exception when peek operation is performed if queue is empty
        // Queue is empty means stack 1 and stack 2 are empty so no copy operation will be performed and peek method will throw an exception
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        moveStack1ToStack2();
        return stack2.peek();
    }

    // Copy elements from stack 1 to stack 2 if stack 2 is empty
    // This is required during the dequeue operation as well as during the peek operation
    // The reason why we are only copying when stack 2 is empty because if we try to copy when some elements are already present in stack 2 then it will not produce the proper output
    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    private boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
