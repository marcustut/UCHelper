package UCHelper.adt;

import java.util.Iterator;

/**
 * CountableNumList.java is an ADT collection that contain almost all the needed
 methods of an NumList to have.
 *
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 4.0
 */
public class CountableNumList<Num> implements CountableNumListInterface<Num> {
    private int[] numList;
    private int size;
    private static final int DEFAULT_SIZE = 5;
    
    public CountableNumList() {
        numList = (int[]) new int[DEFAULT_SIZE];
        size = 0;
    }
    
    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean isListFull() {
        return DEFAULT_SIZE == numList.length;
    }

    @Override
    public int[] copyList(int[] toCopy) {
        int[] resultList = (int[]) new int[DEFAULT_SIZE];
        for (int i = 0; i < size; i++) {
            toCopy[i] = resultList[i];
        }
        return resultList;
    }

    public void doubleList() {
        int[] oldList = copyList(numList);
        int oldSize = oldList.length;
        numList = (int[]) new int[2 * oldSize];
        for (int index = 0; index < oldSize; index++) {
            numList[index] = oldList[index];
        }
    }
    
    @Override
    public void add(int newNum) {
        if (isListFull()) {
            doubleList();
        }
        numList[size++] = newNum;
    }

    @Override
    public void remove(int position) {
        for (int i = position; i < size - 1; i++) {
            numList[i] = numList[i + 1];
        }
        size--;
    }

    @Override
    public boolean replace(int position, int newNum) {
        boolean canReplace = true;
        if ((position >= 1) && (position <= size)) {
            numList[position - 1] = newNum;
        } else {
            canReplace = false;
        }
        return canReplace;
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
    public int getNum(int position) {
        int result = 0;
        if ((position >= 1) && (position <= size)) {
            result = numList[position - 1];
        }
        return result;
    }
    
    @Override
    public int getMax() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (numList[i] > max) {
                max = numList[i];
            }
        }
        return max;
    }

    @Override
    public int getMin() {
        int min = 999;
        for (int i = 0; i < size; i++) {
            if (numList[i] < min) {
                min = numList[i];
            }
        }
        return min;
    }
    
    @Override
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += numList[i];
        }
        return sum;
    }
    
    @Override
    public int getMean() {
        int mean = getSum()/size;
        return mean;
    }

    @Override
    public int getMode() {
        int maxCount = 0;
        int mode = 0;
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; ++j) {
                if (numList[j] == numList[i]) {
                    ++count;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = numList[i];
            }
        }
        return mode;
    }
    
    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < size; ++index) {
            outputStr += numList[index] + "\n";
        }
        return outputStr;
    }
}
