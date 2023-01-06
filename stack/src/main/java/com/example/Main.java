package com.example;

public class Main {
    public static void main(String[] args) {

        StringReverser stringReverser = new StringReverser();
        String reversedString = stringReverser.reverse("abcd");
        System.out.println("Reversed String: " + reversedString);

        ExpressionMatcher expressionMatcher = new ExpressionMatcher();
        boolean isBalanced = expressionMatcher.isBalanced("(1+2)");
        System.out.println("Is input string balanced: " + isBalanced);

    }
}