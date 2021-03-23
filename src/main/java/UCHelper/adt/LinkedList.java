package UCHelper.adt;

import java.util.Iterator;

// TODO: Add the time complexity and space complexity to each operation

/**
 * LinkedList is a helpful data structure for storing a collection of data.
 * It's dynamically allocated, where it grows and shrink at runtime, preventing memory waste.
 * @author Lee Kai Yang RSFY2S2
 * @param <T> - Generic Type (can be any object types but not primitive types)
 */
public class LinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    // TODO: Add a 'tail' variable for better time complexity on add.

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
     * @return size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Check if list is empty
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add an element to the back of the list
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

        while(trav.next != null) {
            trav = trav.next;
        }

        trav.next = new Node<T>(elem, null);
        size++;

        return true;
    }

    /**
     * Remove an element from the list based on its position
     * @param index - position of the element
     * @return the removed element
     */
    public T remove(int index) {
        // If removing the head
        if (index == 0) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }

        Node<T> trav = head;

        for (; index > 1; index--) {
            trav = trav.next;
        }

        T data = trav.next.data;
        trav.next = trav.next.next;
        size--;

        return data;
    }

    /**
     * Replace an element in the list with a new value based on its position
     * @param index - position of the element
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
        trav.next = new Node(newData, trav.next.next);

        return data;
    }

    /**
     * Get the element based on its position in the list
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
     * @param elem - element to check
     * @return true if element exists, false otherwise
     */
    public boolean contains(T elem) {
        Node<T> trav = head;

        while (trav != null) {
            if (trav.data == elem) return true;
            trav = trav.next;
        }

        return false;
    }

    /**
     * Find an element in the list and return its index
     * @param elem - element to find
     * @return index of found element, or -1 if not found
     */
    public int findIndex(T elem) {
        Node<T> trav = head;
        int index = 0;

        while (trav != null) {
            if (trav.data == elem) return index;
            trav = trav.next;
            index++;
        }

        return -1;
    }

    /**
     * Represent the list in string
     * @return string representation of the list
     */
    @Override
    public String toString() {
        if (head == null && size == 0) return "";

        StringBuilder sb = new StringBuilder();

        Node<T> trav = head;

        while (trav != null) {
            sb.append(trav.data + " ");
            trav = trav.next;
        }

        return sb.toString();
    }

    /**
     * Returns an iterator object for the list
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
