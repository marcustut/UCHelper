/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/** A collection of objects that are inserted and removed according to the last-in first-out
 * principle. Although similar in purpose, this interface differs form java.util.Stack
 */
public interface Stack <E> {
    /**
     * Returns the number of elements in the stack @return number of elements in the stack
     */
    int size();
    
    /**
     * Tests whether the stack is empty @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();
    
    /**
     * Inserts an element at the top of the stack @param e the element to be inserted
     */
    void push(E,e);
    
    /**
     * Returns, but does not remove the element at the top of the stack.
     * @return top element in the stack (or null if empty).
     */
    E top();
    
    /**
     * Returns, but does not remove the element at the top of the stack. @return element
     * removed (or null if empty).
     */
    E pop();
}
