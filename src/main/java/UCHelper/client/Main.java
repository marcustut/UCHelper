/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.client;

import UCHelper.adt.*;
import UCHelper.entity.*;

import static UCHelper.client.TestEvent.testEvent;

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
//		BinarySearchTree<Club> clubs = new BinarySearchTree<>();
//		ClubManager clubManager = new ClubManager(clubs);

//		clubs.add(2);
//		clubs.add(1);
//		clubs.add(3);
//		clubs.add(5);

//		Scanner in = new Scanner(System.in);
//		testEvent();

		StudentQueue squ = new StudentQueue();
                squ.studentMainPage();
	}

}
