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

        System.out.println("\n\n\nOutput of two stacks");
        TwoStacks twoStacks = new TwoStacks(5);
        System.out.println("Two stacks initial state: " + twoStacks);
        System.out.println("Is first stack empty? " + twoStacks.isEmpty1());
        System.out.println("Is second stack empty? " + twoStacks.isEmpty2());
        twoStacks.push1(5);
        twoStacks.push2(6);
        System.out.println("Two stacks after inserting one element in each: " + twoStacks);
        twoStacks.push1(3);
        twoStacks.push2(4);
        twoStacks.push2(2);
        System.out.println("Two stacks after inserting 3 more elements: " + twoStacks);
        System.out.println("Is first stack full? " + twoStacks.isFull1());
        System.out.println("Is second stack full? " + twoStacks.isFull2());
        try {
            twoStacks.push1(5);
        } catch (StackOverflowError e) {
            System.out.println("Stack 1 is full, cannot insert more elements.");
        }

        System.out.println("\n\n\nOutput of min stack");
        MinStack minStack = new MinStack();
        System.out.println("Initial state of min stack: " + minStack.printMinStack());
        minStack.push(5);
        minStack.push(2);
        minStack.push(10);
        minStack.push(1);
        System.out.println("Min stack after inserting 4 elements: " + minStack.printMinStack());
        System.out.println("Min item: " + minStack.min());
        minStack.pop();
        System.out.println("Min stack after removing the top element: " + minStack.printMinStack());
        System.out.println("Min item: " + minStack.min());

        System.out.println("\n\n\nOutput of Stack Using Two Queues");
        StackWithTwoQueues stackWithTwoQueues = new StackWithTwoQueues();
        System.out.println("Initial state of stack with two queues: " + stackWithTwoQueues);
        stackWithTwoQueues.push(5);
        stackWithTwoQueues.push(2);
        stackWithTwoQueues.push(10);
        stackWithTwoQueues.push(1);
        System.out.println("Stack with two queues after inserting 4 elements: " + stackWithTwoQueues);
        stackWithTwoQueues.pop();
        System.out.println("Stack with two queues after removing the top element: " + stackWithTwoQueues);
    }
}