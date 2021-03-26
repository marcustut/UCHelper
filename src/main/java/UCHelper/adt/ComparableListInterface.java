package UCHelper.adt;

import java.util.Iterator;
/**
 * ComparableListInterface.java is an ADT collection interface that contain all the methods declaration.
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 2.0
 */
public interface ComparableListInterface<L> {
    public void clear();
    public boolean contains(L toCheck);
    public boolean compare(L firstElement, L secondElement);
    public boolean compareList(L[] toCompare);
    public boolean isListFull();
    public void add(L newElement);
    public boolean addWithin(int position, L newElement);
    public boolean remove(L toRemove);
    public int indexOf(L element);
    public boolean replace(L toReplace, L newElement);
    public boolean replaceAt(int position, L newElement);
    public boolean swap(L firstElement, L secondElement);
    public boolean isEmpty();
    public int getSize();
    public L getElement(int position);
    public String toString();
    public Iterator<L> iterator();
}
