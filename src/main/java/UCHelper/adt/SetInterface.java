/*
 * Name: Amirul Imran bin Ahmad Azam
 * Student ID: 19WMR12634
 * Course: RSF2G1
 * Date: May 2021
 */
package adt;



public interface SetInterface <T> {
boolean add(T newElement);
boolean remove(T anElement) ;
boolean checkSubset(SetInterface anotherSet); 
}
