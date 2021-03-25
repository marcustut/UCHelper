package client;

import entity.Lecturer;
import java.util.Scanner;
import adt.*;
import java.util.Iterator;


public class ManageLecturer { 
    static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    static Set<Lecturer> lecturer = new Set<Lecturer>();
    static Lecturer l = new Lecturer();
    
    
     public static void main( String[] args ){ 
         SetInterface<String> lecturer = new Set<>() {}; //here?
        //system out print choose
        display();
    
     }
     
static void display(){
    char pick;
    do{
    System.out.println("\nWelcome to admin console");
    System.out.println("\nPlease choose: ");
    System.out.println("\nAdd lecturer  :[1]");
    System.out.println("\nDisplay lecturer:[2]");
    System.out.println("\nRemove lecturer  :[3]");
    
    
   
    int choose = myObj.nextInt();  // Read user input     
    
        switch(choose){
            case 1:
                addLecturer();
                break;
                // go to add Lecturer
            case 2:
                displayLecture();
                break;
                // go to display lecturer
            case 3:
                
                removeLecturer();
                break;
                // go to remove lecturer
        
        }System.out.println("Do you wish to continue view lecturer? :");
            System.out.println("if yes enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
                
            }while(pick == 'n'); 
}

static void addLecturer( ){

          
            System.out.println("Enter your full name:");
             String name = myObj.next();                        
                                   
            System.out.println("Enter your username:");
             String username = myObj.next();            
                
            System.out.println("Enter your password:");
             String password = myObj.next();            
                     
            System.out.println("Enter your email:");
             String emailId = myObj.next();            
            
            System.out.println("Enter your contact:");
             String phoneNo = myObj.next();            
            
            lecturer.add(new Lecturer(name,username,password,emailId,phoneNo));
            l.setname(name);
            l.setUserName(username);
            l.setPassword(password);
            l.setEmailId(emailId);
            l.setPhoneNo(phoneNo);
            
}

static void displayLecture(){
        
            System.out.println(lecturer);

}
static void removeLecturer(){
    //SetInterface<String> lecturer = new Set<>() {};     
            //find similar input
            
            System.out.println("Remove lecturer information: ");
            System.out.println("Lecturer full name: ");
            String delName = myObj.next();
            
            System.out.println("Lecturer  username: ");
            String delusername = myObj.next();
            
            System.out.println("Lecturer  password: ");
            String delpassword = myObj.next();
            
            System.out.println("Lecturer  emailId: ");
            String delemailId = myObj.next();
           
            System.out.println("Lecturer  phoneNo: ");
            String delphoneNo = myObj.next();
            
            
            lecturer.remove(new Lecturer(delName,delusername,delpassword,delemailId,delphoneNo));
                
            //delete associate with the input or array
            //back to switch
}

static void CheckLecturer(){
    SetInterface<String> lectChck = new Set<>() {};
    System.out.println("Enter your full name:");
            String Name = myObj.next();                        
                                   
            System.out.println("Enter your username:");
            String username = myObj.next();            
                
            System.out.println("Enter your password:");
            String password = myObj.next();            
                     
            System.out.println("Enter your email:");
            String emailId = myObj.next();            
            
            System.out.println("Enter your contact:");
            String phoneNo = myObj.next();            
            
            lectChck.add(Name);
            lectChck.add(username);
            lectChck.add(password);
            lectChck.add(emailId);
            lectChck.add(phoneNo);
    System.out.println("setA.checkSubset(setB): "+ lectChck.checkSubset(lecturer));
}

}