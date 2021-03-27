/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.adt;

/**
 *
 * @author Cecelia Lim Jie Shi RSFY2S2
 * @param <E>
 */
public interface FlexibleQueueInterface <E extends Comparable<E>>{
    int size();
    boolean isEmpty();
    E first();
    E last();
    void rotate();
    void addFirst(E e);
    void addLast(E e);
    E removeFirst();
    void display();
    void clear();
    public boolean contains(E anEntry);
}
