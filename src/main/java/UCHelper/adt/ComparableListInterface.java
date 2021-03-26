package UCHelper.adt;

import java.util.Iterator;
/**
 * ComparableListInterface.java is an ADT collection interface that contain all the methods declaration.
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 2.0
 */
public interface ComparableListInterface<L> {
    
    public void clear();
    public boolean add(L element);
    public boolean add(int newPosition, L element); 
    public boolean remove(L element);
    public boolean replace(int givenPosition, L element);
    public L getEntry(int givenPosition);
    public boolean contains(L element);
    public int getLength();
    public boolean isEmpty();
    public boolean isFull();
    public String toString();
    public void forEach(L element);
    Iterator<L> iterator();
}
