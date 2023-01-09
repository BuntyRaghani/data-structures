package com.example;

public class Main {
    public static void main(String[] args) {

        StringReverser stringReverser = new StringReverser();
        String reversedString = stringReverser.reverse("abcd");
        System.out.println("Reversed String: " + reversedString);

        ExpressionMatcher expressionMatcher = new ExpressionMatcher();
        boolean isBalanced = expressionMatcher.isBalanced("(1+2)");
        System.out.println("Is input string balanced: " + isBalanced);

        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushing 3 elements: " + stack);
        stack.pop();
        System.out.println("Stack after removing 1 element: " + stack);
        System.out.println("Top element: " + stack.peek());
        System.out.println("is stack empty? " + stack.isEmpty());

    }
}