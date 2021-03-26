package UCHelper.adt;

import java.util.Iterator;

public interface ComparableArrayListInterface<T> {
    public void clear();
    public boolean add(T element);
    public boolean add(int newPosition, T element); 
    public boolean remove(T element);
    public boolean replace(int givenPosition, T element);
    public T getEntry(int givenPosition);
    public boolean contains(T element);
    public int getLength();
    public boolean isEmpty();
    public boolean isFull();
    public String toString();
    public void forEach(T element);
    Iterator<T> getIterator();
}
