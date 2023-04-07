package com.example;

public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(7);
        binaryTree.insert(4);
        binaryTree.insert(9);
        binaryTree.insert(1);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.insert(10);
        System.out.println("Added 7 values in Binary Tree");
        System.out.println("7 Exists in Binary Tree? " + binaryTree.find(7));
        System.out.println("1 Exists in Binary Tree? " + binaryTree.find(1));
        System.out.println("8 Exists in Binary Tree? " + binaryTree.find(8));
        System.out.println("5 Exists in Binary Tree? " + binaryTree.find(5));
    }
}
