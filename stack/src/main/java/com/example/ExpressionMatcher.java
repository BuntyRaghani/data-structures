package com.example;

import java.util.List;
import java.util.Stack;

public class ExpressionMatcher {

    private static final List<Character> rightBrackets = List.of(')', '>', ']', '}');
    private static final List<Character> leftBrackets = List.of('(', '<', '[', '{');

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)) {
                stack.push(ch);
            }
            if (isRightBracket(ch)) {
                if (stack.empty()) return false;

                var topElement = stack.pop();
                if (bracketsMatch(topElement, ch)) return false;
            }
        }
        return stack.empty();
    }

    private static boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private static boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private static boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }
}
