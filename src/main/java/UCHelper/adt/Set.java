/*
 * Name: Amirul Imran bin Ahmad Azam
 * Student ID: 19WMR12634
 * Course: RSF2G1
 * Date: May 2021
 */
package UCHelper.adt;

public class Set<T> implements SetInterface<T> {
    private T[] array;
    private int numberOfEntries;
    private final static int DEFAULT_CAPACITY = 100;

    public Set() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        numberOfEntries = 0;
    }

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
                System.out.println("delete success");
            }
        } else if (!found) {
            System.out.println("information not recognized");
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

}
