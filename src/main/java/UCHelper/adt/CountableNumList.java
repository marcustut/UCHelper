package UCHelper.adt;

/**
 * CountableNumList.java is an ADT collection that contain almost all the needed
 methods of an NumList to have.
 *
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 4.0
 * @param <Num>
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

    public void tripleList() {
        int[] oldList = numList;
        int oldSize = oldList.length;
        numList = (int[]) new int[3 * oldSize];
        for (int index = 0; index < size; index++) {
            numList[index] = oldList[index];
        }
    }
    
    @Override
    public void add(int newNum) {
        if (isListFull()) {
            tripleList();
        }
        numList[size] = newNum;
        size++;
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

    @Override
    public int leastMostDifferent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addition(int firstNum, int secondNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int substration(int firstNum, int secondNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int division(int firstNum, int secondNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int multiplication(int firstNum, int secondNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
