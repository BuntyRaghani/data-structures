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
        DynamicArray dynamicArray = new DynamicArray(5);
        dynamicArray.insert(5);
        dynamicArray.insert(10);
        dynamicArray.insert(15);
        dynamicArray.insert(20);
        dynamicArray.insert(25);
        dynamicArray.insert(30);
        System.out.print("Array after inserting 6 elements: ");
        dynamicArray.print();
        System.out.println("Index of 10: " + dynamicArray.indexOf(10));
        dynamicArray.removeAt(0);

        System.out.print("Array after removing element at index 0: ");
        dynamicArray.print();
        System.out.println("Max element in an array: " + dynamicArray.max());
        dynamicArray.reverse();
        System.out.print("Array after performing the reverse operation: ");
        dynamicArray.print();


        dynamicArray.insertAt(35, 4);
        System.out.print("Array after inserting element 35 at index 4: ");
        dynamicArray.print();
        dynamicArray.insertAt(40, 4);
        System.out.print("Array after inserting element 40 at index 4: ");
        dynamicArray.print();

        DynamicArray newDynamicArray = new DynamicArray(3);
        newDynamicArray.insert(10);
        newDynamicArray.insert(17);
        newDynamicArray.insert(40);
        System.out.print("New dynamic array after inserting 3 elements: ");
        newDynamicArray.print();
        DynamicArray commonItems = dynamicArray.intersect(newDynamicArray);
        System.out.print("Common elements present in both the arrays: ");
        commonItems.print();
    }
}
