/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.adt;

import java.io.Serializable;


/**
 *
 * @author Cecelia Lim Jie Shi RSFY2S2
 * @param <E>
 */
public class FlexibleQueue<E> implements FlexibleQueueInterface <E>,Serializable{

    
    
    //Start of nested Node class
    private static class Node<E>{
        
        private E element;   //reference to the element stored at this node
        private Node<E> next;  //reference to the subsequent node in the list
        
        public Node(E e,Node<E> n){  //Ini adalah constructor??
            element = e;  //E e macam String name?
            next = n;
        }
        
        public E getElement(){
            return element;
        }
        
        public Node<E> getNext(){
            return next;
        }
        
        public void setNext(Node<E> n){
            next = n;
        }
    }
    
    //End of the nested Node class
    
    //instance variables of the CircularlyLinkedList
    private Node<E> tail = null;  // we store tail (but not head)
    private int size = 0;   //number of nodes in the list
    
    public FlexibleQueue() {  //Constructs an initially empty list 
    }
    
    //access methods
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public void clear() {
        tail = tail.next = null;
    }
    
    public E first(){ //returns first element without remove it
        if(isEmpty()) return null;
        return tail.getNext().getElement(); //the head is *after* the tail
    }
    
    public E last(){  //returns last element without remove it
        if(isEmpty()) return null;
        return tail.getElement();
    }
    
    //update methods
    public void rotate(){  //rotate the first element to the back of the list 
        if(tail != null)   //if empty, do nothing
            tail = tail.getNext();   //the old head becomes the new tail
    }
    
    
    public void  addFirst(E e){  //adds element e to the front of the list
        if (size ==0){
            tail = new Node<E>(e, null);  //bcz first in nothing so my tail will become null
            tail.setNext(tail);   //link to itself circularly
        } else {
            Node<E> newest = new Node<E>(e, tail.getNext());    
            tail.setNext(newest); //set after tail mean (first item)
        }
        size++;  //once add item size increase
    }
    
    public void addLast(E e){  //adds element e to the end of the list 
        addFirst(e);    //insert new element at front of list
        tail= tail.getNext();  //now new element becomes the tail
    }
   
    public E removeFirst(){   //removes and returns the first element
        if(isEmpty()) return null;  //nothing to remove
        Node<E> head = tail.getNext();   
        if(head == tail) tail = null; //must be the only node left
        else tail.setNext(head.getNext()); //removes "head" from the list
        size--;
        return head.getElement();
        
    }
    
   
    
    public void display() {
       Node<E> head = tail.getNext();   
       if(head == null){
           System.out.println("Queue is empty");
       }
       else{
           
           do{
               System.out.println(head.getElement());
               head = head.next;
           }while(head != tail.getNext());
           
           System.out.println();
       }
    }

   
    
    
    
  
   
}
