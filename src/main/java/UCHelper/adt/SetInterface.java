/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author muhamadalarif
 */
public interface SetInterface <T> {
boolean add(T newElement);
boolean remove(T anElement) ;
boolean checkSubset(SetInterface anotherSet); 
void union(SetInterface anotherSet);
SetInterface intersection(SetInterface anotherSet);
boolean isEmpty();
Iterator<T> getIterator();

    //public void toArray();


}
