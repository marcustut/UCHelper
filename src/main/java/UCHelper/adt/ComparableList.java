package UCHelper.adt;

import java.util.Iterator;
/**
 * ComparableList.java is an ADT collection that contain all the needed methods of an list to have.
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 4.0
 */
public class ComparableList<L> implements ComparableListInterface<L> {

  private L[] array;
  private int length;
  private static final int DEFAULT_CAPACITY = 5;

  public ComparableList() {
    array = (L[]) new Object[DEFAULT_CAPACITY];
    length = 0;
  }

  @Override
  public boolean contains(L anElement) {
        boolean exist = false;
        for(int i = 0; i < length && !exist; i++){
            if(array[i].equals(anElement))
                exist = true;
        }
        return exist;
  }
  
  @Override
  public boolean add(L newElement) {
        boolean exist = contains(newElement);
        if(!exist){
            array[length++] = newElement;
            return true;
        }
        return false;
  }

  @Override
  public boolean add(int newPosition, L newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
        makeRoom(newPosition);
        array[newPosition - 1] = newEntry;
        length++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public boolean remove(L anElement) {
        int i = 0;
        boolean found = false;
        while(i < length && !found){
            if(array[i].equals(anElement))
                found = true;
            else
                i++;
        }
        if (found){
            for(int j = i; j < length-1; j++){
                array[j] = array[j+1];
            }
            length--;
        }
        return found;
  }

  @Override
  public void clear() {
    length = 0;
  }

  @Override
  public boolean replace(int givenPosition, L newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      array[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  @Override
  public L getEntry(int givenPosition) {
    L result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = array[givenPosition - 1];
    }

    return result;
  }

  @Override
  public int getLength() {
    return length;
  }

  @Override
  public boolean isEmpty() {
    return length == 0;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += array[index] + "\n";
    }
    return outputStr;
  }

  /**
   * Task: Makes room for a new entry at newPosition. Precondition: 1 <=
   * newPosition <= length + 1; length is array's
 length before addition.
   */
  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    // move each entry to next higher index, starting at end of
    // array and continuing until the entry at newIndex is moved
    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  /**
   * Task: Shifts entries that are beyond the entry to be removed to the next
   * lower position. Precondition: array is not empty; 1 <= givenPosition <
 length; length is array's length before removal.
   */
  private void removeGap(int givenPosition) {
    // move each entry to next lower position starting at entry after the
    // one removed and continuing until end of array
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }

    @Override
    public void forEach(L element) {
        throw new UnsupportedOperationException("Not supported yet."); //Lo change body of generated methods, choose Lools | Lemplates.
    }

    @Override
    public Iterator<L> iterator() {
        return new SetIterator();
    }
    
    private class SetIterator implements Iterator<L> {

        private int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
            return iteratorIndex < length;
        }

        @Override
        public L next() {
            if (hasNext()) {
                return array[iteratorIndex++];
            } else {
                return null;
            }
        }
    }
}
