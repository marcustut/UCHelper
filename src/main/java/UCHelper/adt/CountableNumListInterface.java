package UCHelper.adt;
/**
 * CountableNumListInterface.java is an ADT collection interface that contain all
 the methods declaration.
 *
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 2.0
 * @param <Num>
 */
public interface CountableNumListInterface<Num> {
    public void clear();
    public boolean isListFull();
    public void add(int newNum);
    public void remove(int position);
    public boolean replace(int position, int newNum);
    public boolean isEmpty();
    public int getSize();
    public int getNum(int position);
    public int getMax();
    public int getMin();
    public int getSum();
    public int getMean();
    public int getMode();
    public int leastMostDifferent();
    public int addition(int firstNum, int secondNum);
    public int substration(int firstNum, int secondNum);
    public int division(int firstNum, int secondNum);
    public int multiplication(int firstNum, int secondNum);
}
