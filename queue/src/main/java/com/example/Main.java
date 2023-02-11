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

        System.out.println("\n\n\nQueue with two stacks output");
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.enqueue(10);
        queueWithTwoStacks.enqueue(20);
        queueWithTwoStacks.enqueue(30);
        System.out.println("First element: " + queueWithTwoStacks.dequeue());
        System.out.println("First element: " + queueWithTwoStacks.dequeue());
        System.out.println("First Element: " + queueWithTwoStacks.dequeue());

        System.out.println("\n\n\nPriority Queue");
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(6);
        priorityQueue.add(1);
        priorityQueue.add(4);
        System.out.println("Queue after adding 5 elements: " + priorityQueue);
        System.out.println("Is queue full?: " + priorityQueue.isFull());
        System.out.println("Remove an item from queue: " + priorityQueue.remove());
        System.out.println("Remove an item from queue: " + priorityQueue.remove());
        System.out.println("Is queue empty?: " + priorityQueue.isEmpty());

        System.out.println("\n\n\nQueue Reverse with First K Elements");
        Queue<Integer> inputQueue = new ArrayDeque<>();
        inputQueue.add(10);
        inputQueue.add(20);
        inputQueue.add(30);
        inputQueue.add(40);
        inputQueue.add(50);
        System.out.println("Initial input queue: " + inputQueue);
        QueueReverserWithFirstKElements queueReverserWithFirstKElements = new QueueReverserWithFirstKElements();
        queueReverserWithFirstKElements.reverse(inputQueue, 3);
        System.out.println("Queue after reversing elements: " + inputQueue);

    }
}