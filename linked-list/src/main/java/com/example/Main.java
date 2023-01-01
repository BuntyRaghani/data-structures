package com.example;

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
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addFirst(5);
        System.out.println("Index of value 25 in list: " + linkedList.indexOf(25));
        System.out.println("Index of value 20 in list: " + linkedList.indexOf(20));

    }


}
