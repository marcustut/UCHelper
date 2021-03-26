package UCHelper.adt;

import java.util.Iterator;
/**
 * ComparableList.java is an ADT collection that contain almost all the needed methods of an list to have.
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 4.0
 */
public class ComparableList<L> implements ComparableListInterface<L> {
    private L[] list;
    private int size;
    private final static int DEFAULT_SIZE = 4;

    public ComparableList() {
        list = (L[]) new Object[DEFAULT_SIZE];
        size = 0;
    }
  
    @Override
    public void clear() {
        size = 0;
    }
    
    @Override
    public boolean contains(L toCheck) {
        boolean exist = false;
        for (int i = 0; i < size && !exist; i++) {
            if (list[i].equals(toCheck)) {
                exist = true;
            }
        }
        return exist;
    }
    
    @Override
    public boolean compare(L firstElement, L secondElement) {
        boolean similar = false;
        if (firstElement.equals(secondElement)) {
            similar = true;
        }
        else{
            similar = false;
        }  
        return similar;
    }
    
    @Override
    public boolean compareList(L[] toCompare) {
        boolean similar = false;
        if (list.equals(toCompare)) {
            similar = true;
        } else {
            similar = false;
        }
        return similar;
    }

    @Override
    public boolean isListFull() {
        return DEFAULT_SIZE == list.length;
    }

    public void tripleList() {
        L[] oldList = list;
        int oldLength = oldList.length;
        list = (L[]) new Object[3 * oldLength];
        for (int index = 0; index < size; index++) {
            list[index] = oldList[index];
        }
    }
    
    @Override
    public void add(L newElement) {
        if (isListFull()) {
            tripleList();
        }
        list[size] = newElement;
        size++;
    }
    
    private void makeRoom(int position) {
        int indexToMove = position - 1;
        int lastIndex = size - 1;
        for (int index = lastIndex; index >= indexToMove; index--) {
            list[index + 1] = list[index];
        }
    }
    
    @Override
    public boolean addWithin(int position, L newElement) {
        boolean canAdd = true;
        if ((position >= 1) && (position <= size + 1)) {
            makeRoom(position);
            list[position - 1] = newElement;
            size++;
        } else {
            canAdd = false;
        }
        return canAdd;
    }
    
    @Override
    public boolean remove(L toRemove) {
        int i = 0;
        boolean found = false;
        while (i < size && !found) {
            if (list[i].equals(toRemove)) {
                found = true;
            } else {
                i++;
            }
        }
        if (found) {
            for (int j = i; j < size - 1; j++) {
                list[j] = list[j + 1];
            }
            size--;
        }
        return found;
    }
    
    @Override
    public int indexOf(L element) {
        int index = 0;
        if (contains(element)){
            for (int i = 0; i < size; i++) {
                if (list[i].equals(element)) {
                    index = i;
                }
            }
        }
        return index;
    }
    
    @Override
    public boolean replace(L toReplace, L newElement) {
        boolean canReplace = true;
        if (contains(toReplace)) {
            list[indexOf(toReplace)] = newElement;
        } else {
            canReplace = false;
        }
        return canReplace;
    }
    
    @Override
    public boolean replaceAt(int position, L newElement) {
        boolean canReplace = true;
        if ((position >= 1) && (position <= size)) {
            list[position - 1] = newElement;
        } else {
            canReplace = false;
        }
        return canReplace;
    }
    
    @Override
    public boolean swap(L firstElement, L secondElement) {
        boolean canSwap = true;
        int index1 = indexOf(firstElement);
        int index2 = indexOf(secondElement);
        list[index1] = secondElement;
        list[index2] = firstElement;
        return canSwap;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public int getSize() {
        return size;
    }
    
    @Override
    public L getElement(int position) {
        L result = null;
        if ((position >= 1) && (position <= size)) {
            result = list[position - 1];
        }
        return result;
    }
    
    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < size; ++index) {
            outputStr += list[index] + "\n";
        }
        return outputStr;
    }

    @Override
    public Iterator<L> iterator() {
        return new SetIterator();
    }
    
    private class SetIterator implements Iterator<L> {
        private int index = 0;
        
        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public L next() {
            if (hasNext()) {
                return list[index++];
            } else {
                return null;
            }
        }
    }
}
