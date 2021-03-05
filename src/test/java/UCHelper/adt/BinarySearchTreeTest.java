package UCHelper.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

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
    assertEquals(bst.size(), 2);

    // Try removing the root
    assertTrue(bst.remove(1));
    assertTrue(bst.isEmpty());
    assertEquals(bst.size(), 0);
  }

}