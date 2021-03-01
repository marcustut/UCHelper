package UCHelper.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

  private final BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

  @Test
  void test() {
    bst.add(2);
    bst.add(1);
    bst.add(3);
    bst.add(5);

    bst.print(BinarySearchTree.TreeTraversalOrder.PreOrderTraversal);
  }
}