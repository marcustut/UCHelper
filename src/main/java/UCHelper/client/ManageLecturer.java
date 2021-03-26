package client;

import entity.Lecturer;
import java.util.Scanner;
import adt.*;
import java.util.Iterator;


public class ManageLecturer { 
    static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    static Set<Lecturer> lecturer = new Set<Lecturer>();
    static Set<Lecturer> lectChck = new Set<Lecturer>();
    static Lecturer l = new Lecturer();
    
    
     public static void main( String[] args ){ 
         SetInterface<String> lecturer = new Set<>() {}; 
         SetInterface<String> lectChck = new Set<>() {};
        //system out print choose
        display();
    
     }
     
static void display(){
    //char pick;
    //do{
    System.out.println("\nWelcome to admin console");
    System.out.println("\nPlease choose: ");
    System.out.println("\nAdd lecturer  :[1]");
    System.out.println("\nDisplay lecturer:[2]");
    System.out.println("\nRemove lecturer  :[3]");
    System.out.println("\nCheck lecturer  :[4]");
    
    
   
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
            case 4:
                CheckLecturer();
                break;
                // go to check lecturer
        
        /*}System.out.println("Do you wish to continue view lecturer? :");
            System.out.println("if yes enter 'y'");
            System.out.println("if want going back to menu enter 'y'");
            pick = myObj.next().charAt(0);
                
            }while(pick == 'n'); */
}
}
static void addLecturer( ){

         char pick;
    do{ 
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
            
            lecturer.add(new Lecturer(firstName,lastName,username,password,emailId,phoneNo));
            l.setfirstName(firstName);
            l.setlastName(lastName);
            l.setUserName(username);
            l.setPassword(password);
            l.setEmailId(emailId);
            l.setPhoneNo(phoneNo);
            System.out.println("if you wish to continue add lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
              if (pick == 'n')
                  display();
            }while(pick == 'y'); 
}

static void displayLecture(){
         char pick;
        do{ 
        
            System.out.println(lecturer);
            System.out.println("if you wish to continue view lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
              if (pick == 'n')
                  display();
            }while(pick == 'y'); 

}
static void removeLecturer(){
    char pick;
        do{
            
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
            
            lecturer.remove(new Lecturer(delfirstName,dellastName,delusername,delpassword,delemailId,delphoneNo));
            
            System.out.println("if you wish to continue add lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
              if (pick == 'n')
                  display();
            }while(pick == 'y'); 
                
}

static void CheckLecturer(){
    char pick;
        do{
        
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
            lectChck.add(new Lecturer(firstName,lastName,username,password,emailId,phoneNo));
            //lectChck.add(new Lecturer(firstName,lastName,username,password,emailId,phoneNo);
            l.setfirstName(firstName);
            l.setlastName(lastName);
            l.setUserName(username);
            l.setPassword(password);
            l.setEmailId(emailId);
            l.setPhoneNo(phoneNo);
            
            
            System.out.println(lecturer);
            System.out.println(lectChck);
            
            System.out.println("setA.checkSubset(setB): "+ lecturer.checkSubset(lectChck));
            System.out.println("if you wish to continue check lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
              if (pick == 'n')
                  display();
            }while(pick == 'y'); 
}
static void CheckLecturer2(){
     /*char pick;
        do{
        //SetInterface<String> lectChck = new Set<>() {};
        System.out.println("Enter your first name:");
            String firstName = myObj.next();  
            
        System.out.println("Enter your last name:");
            String lastName = myObj.next();
                                   
            System.out.println("Enter your username:");
            String username = myObj.next();            
                
            System.out.println("Enter your email:");
            String emailId = myObj.next();            
            
            System.out.println("Enter your contact:");
            String phoneNo = myObj.next();   
            
            //for(Lecturer in your lecturer set){compare the lecturer ID}
            for (int i = 0; i < 10; i++) {
                lecturer.getfirstname;
                
            }
      System.out.println("Does the Set contains 'Geeks'? " + lecturer.contains(firstName));
  
        // Check for "4" in the set
        System.out.println("Does the Set contains '4'? "
           + lecturer.contains(lastName));
  
        // Check if the Set contains "No"
        System.out.println("Does the Set contains 'No'? "
            + lecturer.contains(username));
        // Check if the Set contains "No"
        System.out.println("Does the Set contains 'No'? "
            + lecturer.contains(emailId));
        // Check if the Set contains "No"
        System.out.println("Does the Set contains 'No'? "
            + lecturer.contains(phoneNo));
        
            System.out.println("if you wish to continue check lecturer enter 'y'");
            System.out.println("if want going back to menu enter 'n'");
            pick = myObj.next().charAt(0);
              if (pick == 'n')
                  display();
            }while(pick == 'y'); 
**/}
}