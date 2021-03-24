/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.client;

import UCHelper.adt.BinarySearchTree;
import static UCHelper.client.EventManager.eventList;
import UCHelper.entity.*;

<<<<<<< Updated upstream
import static UCHelper.client.TestEvent.testEvent;
=======
import java.util.Iterator;
>>>>>>> Stashed changes
import java.util.Scanner;

/**
 *
 * @author Marcus Lee, marcustutorial@hotmail.com
 * @author Cecelia Lim Jie Shi RSFY2S2
 * @author 
 * @author 
 */
public class Main {

<<<<<<< Updated upstream
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
=======
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        boolean exit = false;
	// TODO code application logic here
//	BinarySearchTree<Club> clubs = new BinarySearchTree<>();
//	ClubManager clubManager = new ClubManager(clubs);
//	StudentQueue squ = new StudentQueue();
//	squ.studentMainPage();
        while (exit != true){
            exit = eventUI();
        }
    }
    
    public static String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
>>>>>>> Stashed changes

    public static boolean eventUI(){
        
        //---addEvent(...)
        EventManager e1 = (EventManager) new Event();
        EventManager e2 = (EventManager) new Event();
        e1.addEvent(eventSeqNum++, "event1", "Setapak", "a fund raising event", "11/03/2021", 3);
        e2.addEvent(eventSeqNum++, "event2",  "Sunway", "a fund raising event", "13/03/2021", 4);
        Event e3 = new Event(eventSeqNum++, "event3", "Wangsa", "a fund raising event", "08/02/2021", 4); 
        Event e4 = new Event(eventSeqNum++, "event4", "Aeon", "a fund raising event", "07/03/2021", 5); 
        eventList.add((Event) e1);
        eventList.add((Event) e2);
        eventList.add((Event) e3);
        eventList.add((Event) e4);
        System.out.println(e1.eventHeading());
        for (Event e : eventList) {
            System.out.println(e);
        }
        //---or
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            System.out.println(e);
        }
        return exit;
    }
}
