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

    }
}