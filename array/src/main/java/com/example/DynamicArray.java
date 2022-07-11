package com.example;

/**
 * Create dynamic array using static array
 */
public class DynamicArray {

    // No of items that are currently present in an array
    private int count;

    // Static array
    private int[] internalArray;

    /**
     * Instantiates a new Dynamic array.
     *
     * @param size the size
     */
    public DynamicArray(int size) {
        internalArray = new int[size];
    }

    /**
     * Insert new element in an array.
     * Resize an array if required
     *
     * @param item the item
     */
    public void insert(int item) {
        resizeArrayIfRequired();
        internalArray[count++] = item;
    }

    // Resize an array if required.
    // Once the number of elements reaches max length of an array, a new temp array will be created,
    // elements will be copied from old array to new array and old array reference will be assigned with this new array.
    private void resizeArrayIfRequired() {
        if (internalArray.length == count) {
            int[] newArray = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newArray[i] = internalArray[i];
            }
            internalArray = newArray;
        }
    }

    /**
     * Remove element at specified index.
     *
     * @param index the index
     */
    public void removeAt(int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Kindly provide a valid index value for deletion");
        }
        // Shift all elements to left by 1 position after performing the delete operation
        for (int i = index; i < count - 1; i++) {
            internalArray[i] = internalArray[i + 1];
        }
        // This is to handle the edge case scenario wherein the last element will be replaced with zero once the elements are shifted to left by 1 position after performing the delete operation
        internalArray[count - 1] = 0;

        // Decrement the number of elements present in an array by 1
        count--;
    }

    /**
     * Find index of an element that is present in an array.
     *
     * @param item the item
     * @return the int
     */
    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (internalArray[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Print array elements.
     * Default values will be ignored in this case
     */
    public void print() {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(internalArray[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * Find max element in an array.
     *
     * @return the int
     */
    public int max() {
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (internalArray[i] > max) {
                max = internalArray[i];
            }
        }
        return max;
    }

    /**
     * Reverse an array.
     */
    public void reverse() {
        int[] newArray = new int[count];

        for (int i = 0; i < count; i++) {
            newArray[i] = internalArray[count - 1 - i];
        }
        internalArray = newArray;
    }

    /**
     * Insert an element at specified index.
     *
     * @param item  the item
     * @param index the index
     */
    public void insertAt(int item, int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Kindly provide a valid index value for insertAt operation");
        }

        resizeArrayIfRequired();

        // Shift all elements to right by 1 position so that insert operation can be performed at specified index
        for (int i = count; i >= index + 1; i--) {
            internalArray[i] = internalArray[i - 1];
        }

        // Insert item at specified index
        internalArray[index] = item;

        // Increment the number of elements present in an array by 1
        count++;
    }

    /**
     * Find common elements that are present in internal array and other array provided by user.
     *
     * @param otherDynamicArray the  dynamic array
     * @return the dynamic array
     */
    public DynamicArray intersect(DynamicArray otherDynamicArray) {
        DynamicArray output = new DynamicArray(count);

        for (int item : internalArray) {
            if (otherDynamicArray.indexOf(item) >= 0) {
                output.insert(item);
            }
        }
        return output;
    }

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
