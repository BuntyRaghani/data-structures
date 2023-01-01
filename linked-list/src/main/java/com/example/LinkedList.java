package com.example;


/**
 * Create our own linked list
 */
public class LinkedList {

    // We have declared Node class inside a LinkedList class because it is used internally by LinkedList class only
    private class Node {
        private int value;
        private Node next;

        /**
         * Instantiates a new Node.
         * since we cannot have any node without a value due to which we have created a constructor so that
         * while creating a node, it is mandatory to provide a value
         *
         * @param value the value
         */
        public Node(int value) {
            this.value = value;
        }
    }

    // head
    private Node first;
    // tail
    private Node last;

    /**
     * Add new node at the end of the list.
     *
     * @param item the item
     */
    public void addLast(int item) {
        var node = new Node(item);

        // Two Scenarios
        // 1. If list is empty, we need to point both head and tail to this new node
        // 2. If list is not empty, we just need to append this new node at the end of the list and point tail to this new node

        // If first is null, means list is empty
        if (isEmpty()) {
            first = last = node;
        } else {
            // We have at least one node in the list
            // Now we have to append this new node to last node and update the last node to point to this new node
            last.next = node;
            last = node;
        }
    }

    /**
     * Add new node at the beginning of the list.
     *
     * @param item the item
     */
    public void addFirst(int item) {
        var node = new Node(item);

        // Two Scenarios
        // 1. If list is empty, we need to point both head and tail to this new node
        // 2. If list is not empty, we just need to prepend this new node at the beginning of the list and point head to this new node

        // If first is null, means list is empty
        if(isEmpty()) {
            first = last = node;
        } else {
            // We have at least one node in the list
            // Now we have to prepend this new node to the first node and update the first node to point to this new node
            node.next = first;
            first = node;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }
}
