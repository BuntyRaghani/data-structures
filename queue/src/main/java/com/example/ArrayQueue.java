package com.example;


import java.util.Arrays;

/**
 * The type Array queue.
 * <p>
 * Implementing queue using an array.
 * <p>
 * Implementation approach:
 * In this case, we will have two pointers: front and rear
 * Based on the operation we are trying to perform, we will update these pointers
 * If we want to perform dequeue operation, we will increment the position of front by 1 which will give an illusion of deletion operation.
 * If we want to perform enqueue operation, we will insert the element at position of rear and then increment the rear counter by 1.
 */
public class ArrayQueue {

    private int[] items;

    private int rear;

    private int front;

    // To see if queue is full
    private int count;

    public ArrayQueue(int capacity) {
        this.items = new int[capacity];
    }

    // Insert an element at end of queue
    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        items[rear] = item;

        // Instead of increment the rear just by 1, we are also performing the mod operation with array length
        // Mod operation will give us the remainder which will make this implementation as circular queue
        // This is required in order to fully utilize the capacity of a queue
        // Earlier, after performing few dequeue operations, we were not able to insert the same number of elements. We were getting index out of bounds exception in that case.
        rear = (rear + 1) % items.length;
        count++;
    }

    // Remove element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int item = items[front];

        // while printing a queue it will make it easier for us to understand how many elements are actually there in the queue
        items[front] = 0;

        // Instead of increment the front just by 1, we are also performing the mod operation with array length
        // Mod operation will give us the remainder which will make this implementation as circular queue
        // This is required in order to fully utilize the capacity of a queue
        // Earlier, after performing few dequeue operations, we were not able to insert the same number of elements. We were getting index out of bounds exception in that case.
        front = (front + 1) % items.length;
        count--;

        return item;
    }

    // Return top element from queue without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[front];
    }

    // Check if queue is full
    public boolean isFull() {
        return count == items.length;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
