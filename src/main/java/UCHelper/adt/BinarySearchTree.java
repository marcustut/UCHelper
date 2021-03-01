package UCHelper.adt;

import java.io.*;

public class BinarySearchTree<T extends Comparable<T>> {
  // to keep track of number of nodes in the tree
  private int nodeCount = 0;

  // BST is a rooted tree, so we need to keep track of its root node
  private Node root = null;

  // An enum to classify different traversal methods
  public enum TreeTraversalOrder {
    InOrderTraversal, PreOrderTraversal, PostOrderTraversal
  }

  // an internal class for constructing node in the tree
  private class Node {
    T data;
    Node left, right;

    public Node(T data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  // Check if the tree is empty
  public boolean isEmpty() {
    return nodeCount == 0;
  }

  // Returns the total nodes in the tree
  public int size() {
    return nodeCount;
  }

  /**
   * Add an element in to the tree.
   *
   * @param element - The element to add into the tree
   * @return - Whether the element is successfully added
   */
  public Boolean add(T element) {
    // If the root is empty then set it as the root
    if (root == null) {
      root = new Node(element, null, null);
      nodeCount++;
      return true;
    }

    // If the element is large than root, insert it at right subtree
    if (element.compareTo(root.data) > 0) {
      root.right = add(element, root.right);
      // If the element is smaller than root, insert it at left subtree
    } else if (element.compareTo(root.data) < 0) {
      root.left = add(element, root.left);
      // If the element is equals to root, it cannot be added
      // TODO: Probably should throw an exception here.
    } else {
      return false;
    }

    nodeCount++;
    return true;
  }

  /**
   * A private helper method for inserting node into the tree.
   *
   * @param element - The element to add into the tree
   * @param node    - The node to traverse
   */
  private Node add(T element, Node node) {
    // if the node is null then set it and return
    if (node == null) {
      node = new Node(element, null, null);
      return node;
    }

    // if larger then traverse right subtree
    if (element.compareTo(node.data) > 0) {
      node.right = add(element, node.right);
      // if smaller then traverse right subtree
    } else if (element.compareTo(node.data) < 0) {
      node.left = add(element, node.left);
    }

    // When done setting the subtree just return the node
    return node;
  }

  // Print the traversal of the BST
  public void print(TreeTraversalOrder order) {
    switch (order) {
      case InOrderTraversal:
        break;
      case PreOrderTraversal:
        printPreOrder(root);
        break;
      case PostOrderTraversal:
        break;
      default:
        break;
    }
  }

  // Print the PreOrder traversal of the BST
  private void printPreOrder(Node node) {
    if (node != null) {
      System.out.print(node.data + " ");
      if (node.left != null)
        printPreOrder(node.left);
      if (node.right != null)
        printPreOrder(node.right);
    }
  }

  // Describe the current BST in a tree diagram.
  // public String toString() {
  // StringBuilder buffer = new StringBuilder(50);
  // printBST(buffer, "", "");
  // return buffer.toString();
  // }

  // private void printBST(StringBuilder buffer, String prefix, String
  // childPrefix) {

  // }
}
