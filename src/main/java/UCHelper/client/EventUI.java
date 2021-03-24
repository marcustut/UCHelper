/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.client;

import static UCHelper.client.Main.repeat;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class EventUI {
        Scanner input = new Scanner(System.in); 
        int eventSeqNum = 100;
        int userChoice = 0;
        boolean exit = false;
        while (userChoice != 6||userChoice != 6) {
            System.out.println(repeat("\n", 2));
            System.out.println("===================");
            System.out.println("|| Event Session ||");
            System.out.println("===================");
            System.out.println("[1] Browse event");
            System.out.println("[2] Create an event");
            System.out.println("[3] Display event list");
            System.out.println("[4] Display event schedule");
            System.out.println("[5] Back to main menu");
            System.out.println("[6] Exit UC Helper");
            System.out.println("What you wish to do? ");
            System.out.println(" ");
            while(!input.hasNextInt()){
                userChoice = input.nextInt();
            }
            switch(userChoice)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong Entry \n");
                    break;
            }
        }
}
