package UCHelper.adt;

import java.util.Iterator;

/**
 * BinarySearchTree helps preserve any comparable data in a sorted manner. Note
 * that the tree has distinct keys therefore duplicates are not allowed. This is
 * helpful for organizing unique data.
 * 
 * @author Lee Kai Yang RSFY2S2
 * @param <T> - Generic Type (can be any object types but not primitive types)
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
  // to keep track of number of nodes in the tree
  private int nodeCount = 0;

  // BST is a rooted tree, so we need to keep track of its root node
  private Node root = null;

  /**
   * An enum to classify different traversal methods
   */
  public enum TreeTraversalOrder {
    InOrderTraversal, // (left, root, right)
    PreOrderTraversal, // (root, left, right)
  }

  /**
   * An internal class for constructing node in the tree
   */
  private class Node implements Comparable<Node> {
    T data;
    Node left, right;

    public Node(T data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    @Override
    public int compareTo(Node anotherNode) {
      // Since BST cannot have duplicate, so every node is unique
      // therefore the data within is unique as well.
      return data.compareTo(anotherNode.data);
    }
  }

  /**
   * Check if the tree is empty
   * <p>
   * Since we're storing the node count, checking it is in constant time, so 0(1)
   * </p>
   * 
   * @return true if nodeCount is 0, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return nodeCount == 0;
  }

  /**
   * Returns the total nodes in the tree
   * <p>
   * Since we're storing the node count, accesing it is in constant time, so 0(1)
   * </p>
   */
  @Override
  public int size() {
    return nodeCount;
  }

  /**
   * Return the smallest node in the tree (leftmost node)
   * 
   * @return - the data of the smallest node (leftmost node) in the tree
   */
  @Override
  public T min() {
    // Start from the root node
    Node node = root;

    // Keep looking for the left node until there's none
    while (node.left != null)
      node = node.left;

    // Return the leftmost node
    return node.data;
  }

  /**
   * Return the smallest node counting from the root given
   * 
   * @param root - the root (a node in the tree)
   * @return the data of the smallest node (leftmost node) from the given node
   */
  private T min(Node root) {
    // Start from the root given
    Node node = root;

    // Keep looking for the left node until there's none
    while (node.left != null)
      node = node.left;

    // Return the leftmost node
    return node.data;
  }

  //
  /**
   * Return the greatest node in the tree (rightmost node)
   * 
   * @return the data of the greatest node (rightmost node) in the tree
   */
  @Override
  public T max() {
    // Start from the root node
    Node node = root;

    // Keep looking for the right node until there's none
    while (node.right != null)
      node = node.right;

    // Return the rightmost node
    return node.data;
  }

  /**
   * Search whether the tree contains an element.
   * 
   * @param element - the element to search for
   * @return true if duplicate of the element is found and false otherwise
   */
  @Override
  public boolean contains(T element) {
    return contains(root, element);
  }

  /**
   * Private method to check if the tree contains the element. This works by going
   * down the tree level by level to check for the equivalent element.
   * 
   * @param node    - node of the tree
   * @param element - the element to search for
   * @return true if duplicate of the element is found and false otherwise
   */
  private boolean contains(Node node, T element) {
    // Base case: reached bottom of the tree and found none
    if (node == null)
      return false;

    // If element is larger, traverse the right subtree
    if (element.compareTo(node.data) > 0)
      return contains(node.right, element);
    // If element is smaller, traverse the left subtree
    else if (element.compareTo(node.data) < 0)
      return contains(node.left, element);
    // If the element is equal, the duplicate has been found
    else
      return true;
  }

  /**
   * Add an element in to the tree.
   *
   * @param element - The element to add into the tree
   * @return - Whether the element is successfully added
   */
  @Override
  public boolean add(T element) {
    // If the root is empty then set it as the root
    if (root == null) {
      root = new Node(element, null, null);
      nodeCount++;
      return true;
    }

    // If the element is larger than root, insert it at right subtree
    if (element.compareTo(root.data) > 0)
      root.right = add(element, root.right);
    // If the element is smaller than root, insert it at left subtree
    else if (element.compareTo(root.data) < 0)
      root.left = add(element, root.left);
    // If the element is equals to root, it cannot be added
    else
      return false;

    nodeCount++;
    return true;
  }

  /**
   * A private helper method for inserting node into the tree
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

  /**
   * Remove an element from the tree
   * 
   * @param element - the element to remove
   * @return true if removed successfully, false otherwise
   */
  @Override
  public boolean remove(T element) {
    // If element is in tree
    if (contains(element)) {
      // remove it
      root = remove(root, element);
      nodeCount--;
      return true;
    }
    // unable to remove
    return false;
  }

  /**
   * A private helper method for removing a node from the tree
   * 
   * @param node    - a node to keep track of traversal
   * @param element - the element to remove
   * @return the removed node, null if not exists
   */
  private Node remove(Node node, T element) {
    // Base case: if the tree is empty
    if (node == null)
      return node;

    // Traverse down the tree
    // If smaller then go to left subtree
    if (element.compareTo(node.data) < 0)
      node.left = remove(node.left, element);
    // If larger then go to right subtree
    else if (element.compareTo(node.data) > 0)
      node.right = remove(node.right, element);
    // If is same, we found the one to remove
    else if (element.compareTo(node.data) == 0) {
      // Node with only one child or no child
      if (node.left == null)
        return node.right;
      else if (node.right == null)
        return node.left;

      // Node with two child
      node.data = min(node.right);

      // Delete the inorder successor
      node.right = remove(node.right, root.data);
    }

    return node;
  }

  /**
   * Get an iterator to different traversals of the tree
   * 
   * @param order - the order that the tree should be traversed
   * @return an iterator to the tree
   */
  @Override
  public Iterator<T> traverse(TreeTraversalOrder order) {
    switch (order) {
    case InOrderTraversal:
      return inOrderTraversal();
    case PreOrderTraversal:
      return preOrderTraversal();
    default:
      return null;
    }
  }

  /**
   * Private method to perform in-order traversal
   * 
   * @return an Iterator to the tree
   */
  private Iterator<T> inOrderTraversal() {
    // A stack to keep track of node traversed
    final IterableCustomStack<Node> stack = new IterableCustomStack<>();
    stack.add(root);

    return new Iterator<T>() {
      Node trav = root;

      @Override
      public boolean hasNext() {
        // If root is null means tree is invalid
        // If stack is empty means traverse is complete
        return root != null && !stack.isEmpty();
      }

      @Override
      public T next() {
        // Start at the leftmost node
        while (trav != null && trav.left != null) {
          stack.add(trav.left);
          trav = trav.left;
        }

        // Pop each time the node from stack
        Node node = stack.pop();

        // Look one level down at the right
        if (node.right != null) {
          stack.add(node.right);
          trav = node.right;
        }

        return node.data;
      }
    };
  }

  /**
   * Private method to perform pre-order traversal
   * 
   * @return an Iterator to the tree
   */
  private Iterator<T> preOrderTraversal() {
    // A stack to keep track of node traversed
    final IterableCustomStack<Node> stack = new IterableCustomStack<Node>();

    // The root is the starting point (first node to traverse)
    stack.add(root);

    return new Iterator<T>() {

      @Override
      public boolean hasNext() {
        // If root is null means tree is invalid
        // If stack is empty means traverse is complete
        return root != null && !stack.isEmpty();
      }

      @Override
      public T next() {
        // Root
        Node node = stack.pop();
        // Left (Push the right first because left will get popped first from the stack)
        if (node.right != null)
          stack.add(node.right);
        // Right (Push the left last because it will get popped first from the stack)
        if (node.left != null)
          stack.add(node.left);

        return node.data;
      }
    };
  }
}
