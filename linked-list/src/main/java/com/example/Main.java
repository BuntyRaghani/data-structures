package com.example;

import java.util.Arrays;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        var linkedList = new LinkedList();
        System.out.println("List size before inserting any new element: " + linkedList.size());
        linkedList.addLast(10);
        System.out.println("List size after inserting 1 new element: " + linkedList.size());
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addFirst(5);
        System.out.println("List size after inserting 4 new elements: " + linkedList.size());
        System.out.println("Index of value 25 in list: " + linkedList.indexOf(25));
        System.out.println("Index of value 20 in list: " + linkedList.indexOf(20));
        System.out.println("Is value 25 present in the list? " + linkedList.contains(25));
        System.out.println("Is value 20 present in the list? " + linkedList.contains(20));
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("Linked list to array: " + Arrays.toString(linkedList.toArray()));
        linkedList.reverse();
        System.out.println("Linked list after the reverse operation: " + Arrays.toString(linkedList.toArray()));
        System.out.println("Last node from linked list: " + linkedList.getKthFromTheEnd(1));
        System.out.println("Second last node from linked list: " + linkedList.getKthFromTheEnd(2));

    }


}
