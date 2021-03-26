/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UCHelper.client;

import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import UCHelper.adt.*;
import UCHelper.entity.*;

/**
 *
 * @author Cecelia Lim Jie Shi RSFY2S2
 */
public class StudentQueue {
    private FlexibleQueueInterface<Student> student = new FlexibleQueue<Student>();
    static Scanner input = new Scanner(System.in); //create a scanner input object

 

    public void StudentQueue() {
        StudentQueue s = new StudentQueue();
        s.studentMainPage();
    }
        
    

    public void studentMainPage() {
        char quit = 'Y';
        System.out.println("----- Student Queue For Enter Event -----");
        while(quit == 'Y'){
            System.out.println("[1] Check In Student");
            System.out.println("[2] Generate all Student");
            System.out.println("[3] Find First Check-In Student");
            System.out.println("[4] Find Last Check-In Student");
            System.out.println("[5] Remove Student ");
            System.out.println("[6] Check Student Queue Empty");
            System.out.println("[7] Shift First to Last");
            System.out.println("[8] Clear All");
            System.out.println("Choose your selection");
           
            while (!input.hasNextInt()) {
            input.next();
            System.out.print("\nChoose your selection: ");
            }
            int choice = input.nextInt();
            switch(choice)
            {
                case 1:
                    checkInStudent();
                    break;
                case 2:
                    displayStudent();
                    //getting current date and time using Date class
                    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                    Date dateobj = new Date();
                    System.out.println(df.format(dateobj));
                    break;
                case 3:
                    findFirstStudent();
                    break;
                case 4:
                    findLastStudent();
                    break;
                case 5:
                    removeStudent();
                    break;
                case 6:
                    checkEmpty();
                    break;
                case 7:
                    turnFirstToLast();
                    break;
                case 8:
                    clearAll();
                    break;
                default:
                    System.out.println("Wrong Entry \n");
                    break;
                    
            }
            
            System.out.println("Do you want to continue ? (Y/N)");
             while (input.hasNextInt()) {
             input.next();
             System.out.print("\nDo you want to continue ? (Y/N) ");
            }

            String word = input.next();
           
            word = word.toUpperCase();
            quit = word.charAt(0);
            
        }
    }

    public void findLastStudent() {
        //display last student enter
        System.out.println("                            " + "name\tID");
        System.out.println("The Last Student Check-In : " + student.last());
    }

    public void findFirstStudent() {
        System.out.println("                            " + "name\tID");
        System.out.println("The First Student Check-In : " + student.first());
    }

    public void removeStudent() {
        if(!student.isEmpty()){
            student.removeFirst();
        }else{
            System.out.println("Nothing to remove yet ~");
        }
    }

    public void checkEmpty() {
        System.out.println("List is Empty : " + student.isEmpty());
    }

    public void displayStudent() {
        if(!student.isEmpty()){
        System.out.println("---- Student Entering ----");
        System.out.println("Name\t|\tID");
        
        System.out.println("--------------------------");
        student.display();
        System.out.println("--------------------------");
        System.out.println("Total Number of Student : "+ student.size()+"\n");
       
        }else{
            System.out.println("No one is entering yet ~ ");
        }
    }

    public void checkInStudent() {
        
        String name = " ";
       
        System.out.print("\nStudent Name: ");
        name = input.next();
        System.out.print("\nStudent ID: ");
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("\nStudent ID: ");
        }
        int studID = input.nextInt();
        
        student.addLast(new Student(name, studID));
        
    }

    public void turnFirstToLast() {
        if(!student.isEmpty()){
        student.rotate();
        System.out.println("Successfully turn the first student to last.");
        }else if(student.size() == 1){
            System.out.println("This student is the only one in the queue");
        }else{
            System.out.println("Nothing in the queue.");
        }
    }
    
    public void clearAll(){
        if(!student.isEmpty()){
            student.clear();
            System.out.println("Success clear");
        }else{
            System.out.println("Queue is empty ~");
        }
    }

 }

