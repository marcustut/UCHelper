/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.client;

import UCHelper.adt.*;
import UCHelper.entity.*;

import static UCHelper.client.TestEvent.testEvent;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Marcus Lee, marcustutorial@hotmail.com
 * @author Cecelia Lim Jie Shi RSFY2S2
 * @author
 * @author
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * A method for clearing the terminal screen
     */
    public static void clearScreen() {
        // Clears Screen in Java
        try {
            // If Windows then run 'cls' in cmd
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // BinarySearchTree<Club> clubs = new BinarySearchTree<>();
        // ClubManager clubManager = new ClubManager(clubs);

        ClubHandler.runClubManager(scanner);

        // Scanner in = new Scanner(System.in);
        // testEvent();
        // int select = 0;
        // do {
        // System.out.println("------- UC Helper -------");
        // System.out.println("[1] Admin");
        // System.out.println("[2] Club");
        // System.out.println("[3] Event");
        // System.out.println("[4] Student Queue");
        // System.out.println("[5] Exit");
        // System.out.println("Select [1/2/3/4/5]");
        // select = in.nextInt();
        // switch (select) {
        // case 1:
        // break;
        // case 2:
        // break;
        // case 3:
        // break;
        // case 4:
        // StudentQueue squ = new StudentQueue();
        // squ.studentMainPage();
        // break;
        // default:
        // break;
        // }
        // } while (select >= 1 && select <= 4);

        // in.close();
    }

}
