/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.client;

import UCHelper.adt.*;
import UCHelper.entity.*;

import static UCHelper.client.TestEvent.testEvent;
import java.util.Scanner;

/**
 *
 * @author Marcus Lee, marcustutorial@hotmail.com
 * @author Cecelia Lim Jie Shi RSFY2S2
 * @author 
 * @author 
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

           Scanner in = new Scanner(System.in);
//		testEvent();
            int select = 0; 
            do{
            System.out.println("------- UC Helper -------");
            System.out.println("[1] Admin");
            System.out.println("[2] Club");
            System.out.println("[3] Event");
            System.out.println("[4] Student Queue");
            System.out.println("[5] Exit");
            System.out.println("Select [1/2/3/4/5]");
            while (!in.hasNextInt()) {
            in.next();
            System.out.print("\nSelect [1/2/3/4/5]");
            }
            select = in.nextInt();
            switch(select){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                StudentQueue squ = new StudentQueue();
                squ.studentMainPage();
                    break;
                default:
                    break;
            }
            }while(select >= 1 && select <=4);
	}

}
