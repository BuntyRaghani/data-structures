package com.example;


import java.util.NoSuchElementException;

/**
 * Create our own linked list
 */
public class LinkedList {

    // We have declared Node class inside a LinkedList class because it is used internally by LinkedList class only
    private class Node {
        private int value;
        private Node next;

        /**
         * Instantiates a new Node.
         * since we cannot have any node without a value due to which we have created a constructor so that
         * while creating a node, it is mandatory to provide a value
         *
         * @param value the value
         */
        public Node(int value) {
            this.value = value;
        }
    }

    // head
    private Node first;
    // tail
    private Node last;
    // Keeps a track of number of elements that are currently present in a list
    private int size;

    /**
     * Add new node at the end of the list.
     *
     * @param item the item
     */
    public void addLast(int item) {
        var node = new Node(item);

        // Two Scenarios
        // 1. If list is empty, we need to point both head and tail to this new node
        // 2. If list is not empty, we just need to append this new node at the end of the list and point tail to this new node

        // If first is null, means list is empty
        if (isEmpty()) {
            first = last = node;
        } else {
            // We have at least one node in the list
            // Now we have to append this new node to last node and update the last node to point to this new node
            last.next = node;
            last = node;
        }
        size++;
    }

    /**
     * Add new node at the beginning of the list.
     *
     * @param item the item
     */
    public void addFirst(int item) {
        var node = new Node(item);

        // Two Scenarios
        // 1. If list is empty, we need to point both head and tail to this new node
        // 2. If list is not empty, we just need to prepend this new node at the beginning of the list and point head to this new node

        // If first is null, means list is empty
        if (isEmpty()) {
            first = last = node;
        } else {
            // We have at least one node in the list
            // Now we have to prepend this new node to the first node and update the first node to point to this new node
            node.next = first;
            first = node;
        }
        size++;
    }


    /**
     * Index of item.
     * <p>
     * We need to traverse the list starting from the beginning all the way towards the end
     * As soon as we find a node containing the value that matches with the input item, we return the index
     *
     * @param item the item
     * @return the int
     */
    public int indexOf(int item) {
        // Since we don't have the concept of index in linked list, here we are creating our index for tracking purpose
        int index = 0;

        // We will start with first node and update this current node as we will traverse throughout the list to find our desired value
        var current = first;

        // Traverse the list as long as we have nodes available
        while (current != null) {

            // if value is found, return the index
            if (current.value == item) return index;

            // Else increment the current node to point to the next node and also increment the index value by 1
            current = current.next;
            index++;
        }
        // Value not found in the list, return -1
        return -1;
    }

    /**
     * Check whether item is present in linked list.
     * <p>
     * We need to traverse the list starting from the beginning all the way towards the end
     * As soon as we find a node containing the value that matches with the input item, we return the result stating value is found
     * <p>
     * Here we will reuse the indexOf method because we are already traversing the entire list in case of indexOf method to see whether the value is present in the list or not
     *
     * @param item the item
     * @return the int
     */
    public boolean contains(int item) {
        // If value returned by indexOf method is not equals to -1, it means we have found the desired value in the linked list
        return indexOf(item) != -1;
    }

    /**
     * Remove first node from the linked list.
     */
    public void removeFirst() {
        // Three Scenarios needs to be handled here

        // 1. If list is empty, throw No Such Element exception as thrown by Java linked list class
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // 2. If there is only one node in the list which means first and last node will be the same
        // Make first and last node null
        if (first == last) {
            first = last = null;
        } else {
            // 3. If there are multiple nodes in the list

            // Keep a track a second node because we have to make this node as a first node
            var second = first.next;

            // We have to update the first node so that it points to the second node
            // Also, we need to de-link the next from the current node(existing first node) so that it is eligible for garbage collection
            first.next = null;
            first = second;
        }
        size--;
    }

    /**
     * Remove last node from the linked list.
     */
    public void removeLast() {
        // Three Scenarios needs to be handled here

        // 1. If list is empty, throw No Such Element exception as thrown by Java linked list class
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // 2. If there is only one node in the list which means first and last node will be the same
        // Make first and last node null
        if (first == last) {
            first = last = null;
        } else {
            // 3. If there are multiple nodes in the list

            // Keep a track a second last node because we have to make this node as a last node
            var previous = getPrevious(last);

            // We have to update the last node so that it points to the second last node
            // Also, we need to de-link the next from the last node so that that node that we have removed is eligible for garbage collection
            last = previous;
            last.next = null;
        }
        size--;
    }


    /**
     * Get the size of linked list.
     * <p>
     * Instead of traversing the whole linked list again and again when the size method is called, the best way to implement this solution is
     * To create one internal variable 'size' which will keep a track of number of elements that are currently present in the list
     * This size variable will be incremented and decremented as and when the elements are added/removed from the list
     * <p>
     * Runtime complexity of this optimized solution is O(1)
     * Runtime complexity of traversing the whole list and returning the size is O(n)
     *
     * @return the int
     */
    public int size() {
        return size;
    }


    /**
     * Convert the linked list to an array
     * <p>
     * Traverse the entire list and keep adding node values to an array
     *
     * @return the int [ ]
     */
    public int[] toArray() {

        // Create a new array as per the size of existing linked list
        int[] array = new int[size];

        var current = first;
        int index = 0;
        while (current != null) {
            array[index] = current.value;
            current = current.next;
            index++;
        }
        return array;
    }


    /**
     * Reverse a Linked List in place.
     * <p>
     * This logic is based on previous, current and next nodes wherein
     * previous = first node
     * current = second node
     * next = third node
     * <p>
     * We will iterate from start until current != null which denotes we have reached the end of the linked list
     * <p>
     *   H           T
     * [10 -> 20 -> 30]
     *  p     c     n
     *        p     c     n
     *              p     c     n
     * <p>
     *        T           H
     * o/p: [10 <- 20 <- 30]
     */
    public void reverse() {

        // Handle edge case scenario when list is empty.
        if (isEmpty())
            return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;

            // reversing link of current node to point to the previous node
            current.next = previous;

            // preparing for next iteration
            previous = current;
            current = next;
        }

        // To set last we don't have to traverse the reversed list from start till end this will increase the complexity
        // We can set last before we start traversing the list
        last = first;
        // Since last node.next points to null we have to handle this by setting last.next = null
        last.next = null;

        // When we reach end of linked list, previous variable will be pointing to last node. We can use that to set head
        first = previous;
    }


    /**
     * Gets kth from the end.
     * <p>
     * Find the Kth node from the end of a linked list in one pass.
     * [10 -> 20 -> 30 -> 40 -> 50]
     *              *           *
     * <p>
     * K = 1 = 50
     * K = 2 = 40
     * K= 3 = 30
     * <p>
     * To solve this problem, we will have to make use of two pointers
     * Find the optimal distance between two pointers that are K-1 nodes apart.
     * Example: 3rd node value from the end - 1 = 2. The distance between two pointers should be two nodes
     * <p>
     * Approach:
     * 1. Initially, both the pointers will be at start
     * 2. Start moving the second pointer until the distance between the two pointers is k-1
     * 3. Now, start moving both pointers, one step at a time, until the second pointer reaches the end of the linked list
     * 4. Once the second pointer reaches the end of the linked list, first pointer will be at our desired node i.e. Kth node from the last
     *
     * @param k the k
     * @return the kth node value from the end
     */
    public int getKthFromTheEnd(int k) {

        // If the list is empty, the further code should not run
        // Also, handling situation wherein input k  <= 0
        if (isEmpty() || k <= 0) {
            throw new IllegalStateException();
        }

        // Initially, both the pointers will be at the first node
        var firstPointer = first;
        var secondPointer = first;

        // Move the second pointer k-1 nodes apart
        for (int i = 0; i < k - 1; i++) {
            secondPointer = secondPointer.next;

            // Handling scenario wherein value of Kth node is greater than the total number of nodes in linked list
            if (secondPointer == null) {
                throw new IllegalArgumentException("Input cannot be greater than the size of the linked list");
            }
        }

        // Start moving both the pointers until the second pointer reaches the end of the linked list
        // Once the second pointer reaches the end of the linked list, grab the value from the first pointer
        while (secondPointer != last) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        return firstPointer.value;
    }

    /**
     * Gets middle node value
     *
     * [10 -> 20 -> 30 -> 40 -> 50]
     *              *
     *
     * [10 -> 20 -> 30 -> 40 -> 50 -> 60]
     *               *     *
     *
     * To solve this problem, we will have to make use of two pointers
     * <p>
     * Approach:
     * 1. To find how many nodes should the first and second pointers be apart, Try to find the pattern with odd and even number of nodes in list
     * 2. In both the cases(odd & even number of list), the number of nodes is increasing by two but the position of middle node is increasing by 1
     * 3. Initially, both the pointers will be at start
     * 3. Now, start moving both the pointers, first pointer will be moved 1 step at a time and second pointer will be moved 2 steps at a time
     * 4. Once the second pointer reaches the end of the linked list, first pointer will be at our desired node i.e. middle node
     */
    public void getMiddle() {

        // If the list is empty, the further code should not run
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        // Initially, both the pointers will be at the first node
        var firstPointer = first;
        var secondPointer = first;

        // Traverse through the list until second pointer reaches the last node or second pointer next node is not the last node
        while (secondPointer != last && secondPointer.next != last) {
            // Increment first pointer one step at a time
            // Increment second pointer two steps at a time
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }

        // Result in case of odd no. of nodes in list
        if(secondPointer == last) {
            System.out.println(firstPointer.value);
        } else {
            // in this case, second pointer will be null that means we have even no. of nodes in our list
            System.out.println(firstPointer.value + ", " + firstPointer.next.value);
        }
    }

    // This method is useful to get the previous node of the input node
    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
