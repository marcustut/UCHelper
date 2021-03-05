package UCHelper.adt;

import java.util.Iterator;

import UCHelper.adt.BinarySearchTree.TreeTraversalOrder;

public interface Tree<T extends Comparable<T>> {
  public boolean isEmpty();

  public int size();

  public T min();

  public T max();

  public boolean contains(T element);

  public boolean add(T element);

  public boolean remove(T element);

  public Iterator<T> traverse(TreeTraversalOrder order);
}
