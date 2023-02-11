package com.example;

import java.util.ArrayList;

/**
 * The type Linked list queue.
 * <p>
 * Build a queue using a linked list from scratch. Implement the following operations and calculate their runtime complexities.
 * - enqueue
 * - dequeue
 * - peek
 * - size
 * - isEmpty
 */
public class LinkedListQueue {

    private class Node {
        private int value;
        private Node next;

        /**
         * Instantiates a new Node.
         *
         * @param value the value
         */
        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    /**
     * Enqueue.
     * <p>
     * Insert an element at end of queue
     *
     * @param item the item
     *             <p>
     *             O(1) - Runtime Complexity
     */
    public void enqueue(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    /**
     * Dequeue.
     * <p>
     * Remove element from the front of the queue
     *
     * @return the int
     * <p>
     * O(1) - Runtime Complexity
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }

        int value;
        if (head == tail) {
            value = head.value;
            head = tail = null;
        } else {
            value = head.value;
            var second = head.next;
            head.next = null;
            head = second;
        }
        count--;
        return value;
    }

    /**
     * Is empty.
     * <p>
     * Check if queue is empty
     *
     * @return the boolean
     * <p>
     * O(1) - Runtime Complexity
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Size.
     * <p>
     * Return number of elements present in queue
     *
     * @return the int
     */
    public int size() {
        return count;
    }

    /**
     * Peek.
     * <p>
     * Return top element from queue without removing it
     *
     * @return the int
     * <p>
     * O(1) - Runtime Complexity
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return head.value;
    }

    // O(n) - Runtime Complexity
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();

        Node current = head;
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }
        return list.toString();
    }
}
