/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.client;

import UCHelper.adt.*;

/**
 *
 * @author Marcus Lee, marcustutorial@hotmail.com
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		bst.add(2);
		bst.add(1);
		bst.add(3);
		bst.add(5);

		bst.print(BinarySearchTree.TreeTraversalOrder.PreOrderTraversal);
	}

}
