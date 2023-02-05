package com.example;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Initial queue: " + queue);
        QueueReverser queueReverser = new QueueReverser();
        queueReverser.reverse(queue);
        System.out.println("Queue after reversing elements: " + queue);

        System.out.println("\n\n\nArray Queue Output");
        ArrayQueue arrayQueue = new ArrayQueue(5);
        System.out.println("Initial array queue: " + arrayQueue);
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(15);
        System.out.println("array queue after adding 3 elements: " + arrayQueue);
        arrayQueue.dequeue();
        System.out.println("array queue after removing 1 element: " + arrayQueue);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(25);
        System.out.println("array queue after adding 2 more elements: " + arrayQueue);
        arrayQueue.enqueue(30);
        System.out.println("array queue after adding 1 more element: " + arrayQueue);
        // At this stage circular queue is full, if we try to insert more elements, we will get IllegalStateException
        // arrayQueue.enqueue(30);

    }
}