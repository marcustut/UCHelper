/*
 * Name: Amirul Imran bin Ahmad Azam
 * Student ID: 19WMR12634
 * Course: RSF2G1
 * Date: May 2021
 */
package UCHelper.client;

import UCHelper.adt.*;
import UCHelper.entity.*;
import java.util.Scanner;

public class ManageLecturer {
    static Scanner myObj = new Scanner(System.in); // Create a Scanner object
    static Set<Lecturer> lecturer = new Set<Lecturer>();
    static Set<Lecturer> lectChck = new Set<Lecturer>();
    static Lecturer l = new Lecturer();

    public static void main(String[] args) {
        SetInterface<String> lecturer = new Set<>();
        SetInterface<String> lectChck = new Set<>();
        // system out print choose
        display();

    }

    static void display() {
        boolean exit = false;

        // Loop forever until user exists
        while (!exit) {
            System.out.println("\nWelcome to admin console");
            System.out.println("\nPlease choose: ");
            System.out.println("\nAdd lecturer  :[1]");
            System.out.println("\nDisplay lecturer:[2]");
            System.out.println("\nRemove lecturer  :[3]");
            System.out.println("\nCheck lecturer  :[4]");
            System.out.println("\nExit to Main Menu  :[5]");

            int choose = myObj.nextInt(); // Read user input

            switch (choose) {
            // go to add Lecturer
            case 1:
                addLecturer();
                break;
            // go to display lecturer
            case 2:
                displayLecture();
                break;
            // go to remove lecturer
            case 3:
                removeLecturer();
                break;
            // go to check lecturer
            case 4:
                checkLecturer();
                break;
            // exit to main menu
            case 5:
                Main.clearScreen();
                exit = true;
                break;
            default:
                System.out.println("Only accept input from '1 - 5', Try again.");
                break;
            }
        }
    }

    static void addLecturer() {

        char pick;
        do {
            System.out.println("Enter your first name:");
            String firstName = myObj.next();

            System.out.println("Enter your last name:");
            String lastName = myObj.next();

            System.out.println("Enter your username:");
            String username = myObj.next();

            System.out.println("Enter your password:");
            String password = myObj.next();

            System.out.println("Enter your email:");
            String emailId = myObj.next();

            System.out.println("Enter your contact:");
            String phoneNo = myObj.next();
		
		System.out.println("Enter your responsible club:");
             String respClub = myObj.next(); 

            lecturer.add(new Lecturer(firstName, lastName, username, password, emailId, phoneNo,respClub));
            l.setfirstName(firstName);
            l.setlastName(lastName);
            l.setUserName(username);
            l.setPassword(password);
            l.setEmailId(emailId);
            l.setPhoneNo(phoneNo);
		l.setrespClub(respClub);

            System.out.println("if you wish to continue add lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
            if (pick == 'n')
                display();
        } while (pick == 'y');
    }

    static void displayLecture() {
        char pick;
        do {

            System.out.println(lecturer);
            System.out.println("if you wish to continue view lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
            if (pick == 'n')
                display();
        } while (pick == 'y');

    }

    static void removeLecturer() {
        char pick;
        do {

            System.out.println("Remove lecturer information: ");
            System.out.println("Lecturer first name: ");
            String delfirstName = myObj.next();

            System.out.println("Lecturer last name: ");
            String dellastName = myObj.next();

            System.out.println("Lecturer  username: ");
            String delusername = myObj.next();

            System.out.println("Lecturer  password: ");
            String delpassword = myObj.next();

            System.out.println("Lecturer  emailId: ");
            String delemailId = myObj.next();

            System.out.println("Lecturer  phoneNo: ");
            String delphoneNo = myObj.next();

		System.out.println("Lecturer  responsible club: ");
            String delrespClub = myObj.next();

            lecturer.remove(new Lecturer(delfirstName, dellastName, delusername, delpassword, delemailId, delphoneNo, delrespClub));

            System.out.println("if you wish to continue remove lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
            if (pick == 'n')
                display();
        } while (pick == 'y');

    }

    static void checkLecturer() {
        char pick;
        do {

            System.out.println("Enter your first name:");
            String firstName = myObj.next();

            System.out.println("Enter your last name:");
            String lastName = myObj.next();

            System.out.println("Enter your username:");
            String username = myObj.next();

            System.out.println("Enter your first name:");
            String password = myObj.next();

            System.out.println("Enter your email:");
            String emailId = myObj.next();

            System.out.println("Enter your contact:");
            String phoneNo = myObj.next();
			
		System.out.println("Enter your responsible club:");
            String respClub = myObj.next(); 

            lectChck.add(new Lecturer(firstName, lastName, username, password, emailId, phoneNo,respClub));
            l.setfirstName(firstName);
            l.setlastName(lastName);
            l.setUserName(username);
            l.setPassword(password);
            l.setEmailId(emailId);
            l.setPhoneNo(phoneNo);
		l.setrespClub(respClub);

            if (lecturer.checkSubset(lectChck) == true) {
                System.out.println("Lecturer had already registered.");
            } else if (lecturer.checkSubset(lectChck) != true) {
                System.out.println("Lecturer does not exist.");
            }
            System.out.println("if you wish to continue check lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
            if (pick == 'n')
                display();
        } while (pick == 'y');
    }

}