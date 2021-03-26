package UCHelper.adt;

import java.util.Iterator;

/**
 * LinkedListStack is a helpful data structure for storing a collection of data.
 * It's dynamically allocated, where it grows and shrink at runtime, preventing
 * memory waste. Addtionally, since it's a stack, it follows the LIFO (Last In
 * First Out) principle.
 * 
 * @author Lee Kai Yang RSFY2S2
 * @param <T> - Generic Type (can be any object types but not primitive types)
 */
public class LinkedListStack<T extends Comparable<T>> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Get the size of the list
     * <p>
     * We are storing the list size so accessing it is constant time, so O(1)
     * </p>
     * 
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Check if list is empty
     * <p>
     * We are storing the list size so check if it's empty is constant time, so O(1)
     * </p>
     * 
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add an element to the back of the list
     * <p>
     * In the worst case scenario, we have to iterate till the last element so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @param elem - element to be added
     * @return true if element is added, false otherwise
     */
    public boolean add(T elem) {
        // If list is empty
        if (head == null && size == 0) {
            head = new Node<T>(elem, null);
            size++;
            return true;
        }

        Node<T> trav = head;

        while (trav.next != null) {
            trav = trav.next;
        }

        trav.next = new Node<T>(elem, null);
        size++;

        return true;
    }

    /**
     * Pop an element from the top of the list
     * <p>
     * In the worst case scenario, we have to iterate till the last element so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @return data if found, null otherwise
     */
    public T pop() {
        // If list is empty
        if (head == null && size == 0)
            return null;

        // If list only has the head
        if (size == 1) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }

        Node<T> trav = head;

        // Iterate to the node before last
        for (int i = size - 1; i > 1; i--)
            trav = trav.next;

        // Take the last node data
        T data = trav.next.data;

        // Set the tail to null
        trav.next = null;

        size--;

        return data;
    }

    /**
     * Get the last element in the list
     * <p>
     * In the worst case scenario, we have to iterate till the last element so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @return data if found, null otherwise
     */
    public T peek() {
        // If list is empty
        if (head == null && size == 0)
            return null;

        // If list only has head
        if (size == 1)
            return head.data;

        Node<T> trav = head;

        // Iterate to the node before last
        for (int i = size - 1; i > 1; i--)
            trav = trav.next;

        // Take the last node data
        T data = trav.next.data;

        return data;
    }

    /**
     * Remove an element from the list based on its position
     * <p>
     * In the worst case scenario, we have to iterate till the last element so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @param index - position of the element
     * @return the removed element
     */
    public T remove(int index) {
        // index out of bounds
        if (index >= size)
            return null;

        // If removing the head
        if (index == 0) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }

        Node<T> trav = head;

        for (; index > 1; index--)
            trav = trav.next;

        T data = trav.next.data;
        trav.next = trav.next.next;
        size--;

        return data;
    }

    /**
     * Replace an element in the list with a new value based on its position
     * <p>
     * In the worst case scenario, we have to iterate till the last element so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @param index   - position of the element
     * @param newData - new value to replace with
     * @return original value of the element before getting replaced
     */
    public T replace(int index, T newData) {
        // If replacing the head
        if (index == 0) {
            T data = head.data;
            head = new Node<T>(newData, head.next);
            return data;
        }

        Node<T> trav = head;

        for (; index > 1; index--) {
            trav = trav.next;
        }

        T data = trav.next.data;
        trav.next = new Node<T>(newData, trav.next.next);

        return data;
    }

    /**
     * Get the element based on its position in the list
     * <p>
     * In the worst case scenario, we have to iterate till the last element so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @param index - position of the element
     * @return data of the element
     */
    public T get(int index) {
        Node<T> trav = head;

        for (; index > 0; index--) {
            trav = trav.next;
        }

        return trav.data;
    }

    /**
     * Check if the list contains an element
     * <p>
     * In the worst case scenario, we have to iterate till the last element so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @param elem - element to check
     * @return true if element exists, false otherwise
     */
    public boolean contains(T elem) {
        Node<T> trav = head;

        while (trav != null) {
            if (trav.data.compareTo(elem) == 0)
                return true;
            trav = trav.next;
        }

        return false;
    }

    /**
     * Find an element in the list and return its index
     * <p>
     * In the worst case scenario, we have to iterate till the last element so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @param elem - element to find
     * @return index of found element, or -1 if not found
     */
    public int findIndex(T elem) {
        Node<T> trav = head;
        int index = 0;

        while (trav != null) {
            if (trav.data.compareTo(elem) == 0)
                return index;
            trav = trav.next;
            index++;
        }

        return -1;
    }

    /**
     * Represent the list in string
     * <p>
     * We have to iterate through the list to construct the string so Time
     * Complexity is O(n) where n is the size of the list
     * </p>
     * 
     * @return string representation of the list
     */
    @Override
    public String toString() {
        if (head == null && size == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        Node<T> trav = head;

        while (trav != null) {
            sb.append(trav.data + " ");
            trav = trav.next;
        }

        return sb.toString();
    }

    /**
     * Returns an iterator object for the list.
     * <p>
     * Constant time operation because we are just returning an iterator we are not
     * iterating through the list, therefore O(1)
     * </p>
     * 
     * @return an iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }
}
