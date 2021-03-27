package UCHelper.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.logging.Logger;

class BinarySearchTreeTest {
  private final static Logger log = Logger.getLogger(BinarySearchTreeTest.class.getName());

  @Test
  public void testIsEmpty() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    assertTrue(bst.isEmpty());

    bst.add(5);

    assertFalse(bst.isEmpty());
  }

  @Test
  public void testSize() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    assertEquals(bst.size(), 0);

    bst.add(5);

    assertEquals(bst.size(), 1);
  }

  @Test
  public void testMin() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    bst.add(5);
    bst.add(1);

    assertEquals(bst.min(), Integer.valueOf(1));
  }

  @Test
  public void testMax() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    bst.add(5);
    bst.add(1);

    assertEquals(bst.max(), Integer.valueOf(5));
  }

  @Test
  public void testContains() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    bst.add(5);
    bst.add(1);

    assertTrue(bst.contains(5));
    assertTrue(bst.contains(1));
    assertFalse(bst.contains(6));
  }

  @Test
  public void testAdd() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    assertTrue(bst.add(1));

    // A binary search tree cannot contain duplicate element
    assertFalse(bst.add(1));

    assertTrue(bst.add(5));
  }

  @Test
  public void testRemove() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    // Try removing an element which doesn't exist
    bst.add(1);
    assertEquals(bst.size(), 1);
    assertFalse(bst.remove(2));
    assertEquals(bst.size(), 1);

    // Try removing an element which exist
    bst.add(2);
    assertEquals(bst.size(), 2);
    assertTrue(bst.remove(2));
    assertEquals(bst.size(), 1);

    // Try removing the root
    assertTrue(bst.remove(1));
    assertTrue(bst.isEmpty());
    assertEquals(bst.size(), 0);
  }

  @Test
  public void testTraverse() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    StringBuilder sb = new StringBuilder();

    bst.add(100);
    bst.add(20);
    bst.add(10);
    bst.add(30);
    bst.add(200);
    bst.add(150);
    bst.add(300);

    // Testing for InOrderTraversal
    Iterator<Integer> itr = bst.traverse(BinarySearchTree.TreeTraversalOrder.InOrderTraversal);

    while (itr.hasNext()) {
      Integer i = itr.next();
      sb.append(i + ", ");
    }

    assertEquals("10, 20, 30, 100, 150, 200, 300, ", sb.toString());

    // Testing for PreOrderTraversal
    Iterator<Integer> itr2 = bst.traverse(BinarySearchTree.TreeTraversalOrder.PreOrderTraversal);
    StringBuilder sb2 = new StringBuilder();

    while (itr2.hasNext()) {
      Integer i = itr2.next();
      sb2.append(i + ", ");
    }

    assertEquals("100, 20, 10, 30, 200, 150, 300, ", sb2.toString());
  }
}