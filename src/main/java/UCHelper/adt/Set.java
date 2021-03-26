/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.adt;

import java.util.Iterator;

public class Set<T> implements SetInterface<T> {
    private T[] array;
    private int numberOfEntries;
    private final static int DEFAULT_CAPACITY = 100;

    public Set() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        numberOfEntries = 0;
    }

    /*
     * public Object toArray() { int num =0; int n = 0; for (int i = num; i <
     * numberOfEntries; i++){
     * 
     * Object[] arr[n] = (Object[]) array[i]; n = n+1; num=num+5; } return null; }
     */

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < numberOfEntries; i++) {
            str += array[i] + "";
        }
        return str;
    }

    @Override
    public boolean remove(T anElement) {
        int i = 0;
        boolean found = false;
        while (i < numberOfEntries && !found) {
            if (array[i].equals(anElement))
                found = true;
            else
                i++;
        }
        if (found) {
            for (int j = i; j < numberOfEntries; j++) {
                array[j] = array[j + 1];
            }
        }
        return found;
    }

    @Override
    public boolean checkSubset(SetInterface anotherSet) {
        Set<T> givenSet = (Set<T>) anotherSet;
        for (int i = 0; i < givenSet.numberOfEntries; i++) {
            if (!this.contains(givenSet.array[i]))
                return false;
        }
        return true;
    }

    @Override
    public void union(SetInterface anotherSet) {
        Set<T> givenSet = (Set<T>) anotherSet;
        for (int i = 0; i < givenSet.numberOfEntries; i++) {
            this.add(givenSet.array[i]);
        }
    }

    @Override
    public SetInterface intersection(SetInterface anotherSet) {
        Set<T> givenSet = (Set<T>) anotherSet;
        Set<T> resultSet = new Set<>() {
        };
        for (int i = 0; i < givenSet.numberOfEntries; i++) {
            if (this.contains(givenSet.array[i]))
                resultSet.add(givenSet.array[i]);
        }
        return resultSet;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newElement) {
        boolean exist = contains(newElement);
        if (!exist) {
            array[numberOfEntries++] = newElement;
            return true;
        }
        return false;
    }

    public boolean contains(T newElement) {
        boolean exist = false;
        for (int i = 0; i < numberOfEntries && !exist; i++) {
            if (array[i].equals(newElement))
                exist = true;
        }
        return exist;
    }

    @Override
    public Iterator<T> getIterator() {
        return new SetIterator();
    }

    private class SetIterator implements Iterator<T> {
        private int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
            return iteratorIndex < numberOfEntries;
        }

        @Override
        public T next() {
            if (hasNext())
                return array[iteratorIndex++];
            else
                return null;
        }
    }
}
