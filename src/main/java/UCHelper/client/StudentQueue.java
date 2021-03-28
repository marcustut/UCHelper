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
    DutyHandler d = new DutyHandler();
    static Scanner input = new Scanner(System.in); //create a scanner input object
 
 

    public void StudentQueue() {
        boolean exit = false;
        int select;
        StudentQueue s = new StudentQueue();
        while(!exit){
        System.out.println("\nCheck In Duty, before use [Student Queue]");
        System.out.println("[1] Check-In Duty");
        System.out.println("[2] Display Duty People");
        System.out.println("[3] Exit");
        System.out.println("Choose [1/2/3]");
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("\nChoose [1/2/3] ");
            }
         select = input.nextInt();
         
         switch (select) {
             case 1 :
                 s.checkInDuty();
                 System.out.println("\n");
                 s.studentMainPage();
                 break;
             case 2 :
                 s.displaycheckinDuty();
                 break;
             case 3 :
                Main.clearScreen();
                exit = true;
                break;
             default :
                 System.out.println("Accept input from '1 - 3', Try again.");
                 break;
                
         }
        }
    }
        
    public void checkInDuty(){
        System.out.println("[Lecturer On-Duty]");
        System.out.println("Enter Name : ");
        String lecturer = input.next();
        
        System.out.println("Enter Phone No : ");
        String phoneNo = input.next();
        
        System.out.println("Enter in-charged Club : ");
        String club = input.next();
        
        System.out.println("");
        
        System.out.println("[Student On-Duty]");
        System.out.println("Enter Name : ");
        String student = input.next();
        
        System.out.println("Enter ID : ");
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("\nEnter ID: ");
        }
        int id = input.nextInt();
        
        d.dutyLec.add(new Lecturer(lecturer,phoneNo,club));
       
        d.dutyStud.add(new Student(student,id));
    }
    
    public void displaycheckinDuty(){
        System.out.println("This check-in duty is recorded ...");
        
        System.out.println("[Lecturer Record]");
        d.dutyLec.add(new Lecturer("Dr.Ting","0123456789","Computer Science Club"));
        System.out.println(d.dutyLec);
        System.out.println("");
        
        System.out.println("[Student Record]");
        d.dutyStud.add(new Student("Chirstine", 1814567));
        System.out.println(d.dutyStud);
        System.out.println("");
       
        
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
                    displayCurrentTime();
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
            
            quit = exitPage();
            
        }
    }

    public char exitPage() {
        char quit;
        System.out.println("Do you want to continue ? (Y/N)");
        while (input.hasNextInt()) {
            input.next();
            System.out.print("\nDo you want to continue ? (Y/N) ");
        }
        String word = input.next();
        word = word.toUpperCase();
        quit = word.charAt(0);
        return quit;
    }

    public void displayCurrentTime() {
        //getting current date and time using Date class
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        System.out.println("");
    }

    public void findLastStudent() {
        //display last student enter
        System.out.println("The Last Student Check-In : \n" + student.last());
    }

    public void findFirstStudent() {
        System.out.println("The First Student Check-In : \n" + student.first());
    }

    public void removeStudent() {
        if(!student.isEmpty()){
            System.out.println("Delete" + student.first());
            student.removeFirst();
        }else{
            System.out.println("Nothing to remove yet ~");
        }
    }

    public void checkEmpty() {
        System.out.println("Queue is Empty : " + student.isEmpty());
    }

    public void displayStudent() {
        if(!student.isEmpty()){
        System.out.println("\n[Student Entering]");
        
        student.display();
        System.out.println("Total Number of Student : "+ student.size()+"\n");
       
        }else{
            System.out.println("No one is entering yet ~ ");
        }
    }
    
    public void checkInStudent() {
        
        String name = " ";
        System.out.println("Enter your info ...");
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
        student.display();
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

