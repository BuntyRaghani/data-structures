package com.example;

public class Main {
    public static void main(String[] args) {

        StringReverser stringReverser = new StringReverser();
        String reversedString = stringReverser.reverse("abcd");
        System.out.println("Reversed String: " + reversedString);

    }
}