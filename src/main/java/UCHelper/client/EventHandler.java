package UCHelper.client;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Date;
import UCHelper.adt.ComparableList;
import UCHelper.adt.CountableNumList;
import UCHelper.entity.*;
import java.util.concurrent.TimeUnit;
/**
 * EventManager.java is an client class that contain all the needed methods of an event interface.
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 4.0
 */
public class EventHandler{
    static ComparableList<Event> eventList = new ComparableList<Event>();
    static Scanner in = new Scanner(System.in);
    static int eventSeqNum = 100;    
    private static final String DEFAULT_POSITION = "Member  ";
    private static final int DEFAULT_COCU_MARK_FOR_MEMBER = 80;
    private static final int DEFAULT_COCU_MARK_FOR_COMMITTEE = 90;
    private static final int DEFAULT_COCU_MARK_FOR_PRESIDENT = 95;
    private static final int DEFAULT_PROCESSING_TIME = 1;
    
    //For others to use, public/accessible by others
    public static boolean dummyData() {
        //---addEvent(...)
        Event e1 = new Event(eventSeqNum++, "event1", "Wangsa", "a fund raising event", "08/02/2020", 4);
        Event e2 = new Event(eventSeqNum++, "event2", "Aeon", "a fund raising event", "07/05/2021", 5);
        Event e3 = new Event(eventSeqNum++, "event3", "TAR UC", "a fund raising event", "05/03/2021", 5);
        e1.setOrganisor("C-100");
        e2.setOrganisor("C-121");
        e3.setOrganisor("C-154");

        e1.setAttendeeList("19WMR11944");
        e1.setAttendeePosition("Committee");
        e1.setAttendeeCocuMarks(90);
        e1.setAttendeeList("19WMR11933");
        e1.setAttendeePosition("President");
        e1.setAttendeeCocuMarks(95);
        e1.setAttendeeList("19WMR11924");
        e1.setAttendeePosition(DEFAULT_POSITION);
        e1.setAttendeeCocuMarks(DEFAULT_COCU_MARK_FOR_MEMBER);
        e1.setAttendeeList("19WMR11925");
        e1.setAttendeePosition(DEFAULT_POSITION);
        e1.setAttendeeCocuMarks(DEFAULT_COCU_MARK_FOR_MEMBER);
        e1.setAttendeeList("19WMR11926");
        e1.setAttendeePosition(DEFAULT_POSITION);
        e1.setAttendeeCocuMarks(DEFAULT_COCU_MARK_FOR_MEMBER);

        e2.setAttendeeList("18WMR11934");
        e2.setAttendeePosition(DEFAULT_POSITION);
        e2.setAttendeeCocuMarks(DEFAULT_COCU_MARK_FOR_MEMBER);
        e2.setAttendeeList("18WMR11925");
        e2.setAttendeePosition(DEFAULT_POSITION);
        e2.setAttendeeCocuMarks(DEFAULT_COCU_MARK_FOR_MEMBER);

        eventList.add((Event) e1);
        eventList.add((Event) e2);
        eventList.add((Event) e3);
        return false;
    }
    
    public boolean registerEvent(Event event) {
        eventList.add(event);
        return true;
    }

    public Event removeEvent(int eventSeqNum) {
        String ID = "E-" + eventSeqNum;
        Event removedEvent = new Event();
        ComparableList<Event> tem = new ComparableList<Event>();
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            if (!e.getEventID().equals(ID)) {
                tem.add(e);
            }
        }
        eventList = tem;
        System.out.println("");
        return removedEvent;
    }

    public ComparableList<Event> getEvents() {
        return eventList;
    }

    public Event getEvent(int eventSeqNum) {
        String ID = "E-" + eventSeqNum;
        Event event = new Event();
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            if (!e.getEventID().equals(ID)) {
                event = e;
            }
        }
        System.out.println("");
        return event;
    }
    
    public static void EventUI(){
        int userChoice = 0;
        System.out.println(eventHeading());
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            System.out.println(e);
        }
        do {
            System.out.println("------- UC Helper -------");
            System.out.println("[1] Browse event");
            System.out.println("[2] Create an event");
            System.out.println("[3] Edit an existing event");
            System.out.println("[4] Delete an existing event");
            System.out.println("[5] Display current event list");
            System.out.println("[6] Delete all event in the list");
            System.out.println("[7] Display all the past event before today");
            System.out.println("[8] Display event list with their number of attendees");
            System.out.println("[9] Back to main menu");
            System.out.println("[0] Features for testing ADT");
            System.out.println("What you wish to do? ");
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("\nSelect [1/2/3/4/5/6/7/8/9]");
            }
            userChoice = in.nextInt();
            switch (userChoice) {
                case 0:
                    adtShowcase();
                    break;
                case 1:
                    browseEvent();
                    break;
                case 2:
                    createEvent();
                    break;
                case 3:
                    editEvent();
                    break;
                case 4:
                    deleteEvent();
                    break;
                case 5:
                    displayEventList();
                    break;
                case 6:
                    deleteEventList();
                    break;
                case 7:
                    displayPastEvent();
                    break;
                case 8:
                    displayEventListWithAttendeeList();
                    break;
                default:
                    System.out.println("");
                    System.out.println("exiting eventUI...");
                    try {
                        TimeUnit.SECONDS.sleep(DEFAULT_PROCESSING_TIME);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        } while (userChoice >= 0 && userChoice <= 8);
    }
    
    //For internal usage, contain main method logics and program flows
    private static void adtShowcase() {
        int userChoice = 0;
        do {
            System.out.println("------- ADT Show House -------");
            System.out.println("[1] ComparableList.java");
            System.out.println("[2] CountableNumList.java");
            System.out.println("[3] Back to event module");
            System.out.println("Please pick one... ");
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("\nSelect [1/2/3]");
            }
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1:
                    comparableList();
                    break;
                case 2:
                    countableNumList();
                    break;
                default:
                    break;
            }
        } while (userChoice >= 1 && userChoice <= 2);
    }
    
    private static void comparableList() {
        int userChoice = 0;
        ComparableList<String> a = new ComparableList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        ComparableList<String> b = new ComparableList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        do {
            System.out.println("");
            System.out.println("------- ComparableList ADT -------");
            System.out.println("[1] clear");
            System.out.println("[2] contain");
            System.out.println("[3] compare");
            System.out.println("[4] isListFull");
            System.out.println("[5] add");
            System.out.println("[6] addWithin");
            System.out.println("[7] remove");
            System.out.println("[8] indexOf");
            System.out.println("[9] replace");
            System.out.println("[10] replaceAt");
            System.out.println("[11] swap");
            System.out.println("[12] isEmpty");
            System.out.println("[13] getSize");
            System.out.println("[14] getElement");
            System.out.println("[15] toString");
            System.out.println("[16] Back to previous page");
            System.out.println("Please pick one... ");
            while (!in.hasNextInt()) {
                in.next();
            }
            userChoice = in.nextInt();
            switch (userChoice){
                case 1 :
                    System.out.println("Before clear : " + b);
                    b.clear();
                    System.out.println("After clear  : " + b);
                    break;
                case 2:
                    System.out.println("a.contains(\"a\") :" + a.contains("a"));
                    break;
                case 3:
                    System.out.println("a.compare(\"a\",\"a\") :" + a.compare("a","a"));
                    break;
                case 4:
                    System.out.println("a.isListFull() :" + a.isListFull());
                    break;
                case 5:
                    a.add("z");
                    System.out.println("a.add(\"z\") :" + a);
                    break;
                case 6:
                    a.addWithin(2,"v");
                    System.out.println("a.addWithin(2,\"v\") :" + a);
                    break;
                case 7:
                    a.remove("z");
                    System.out.println("a.remove(\"z\") :" + a);
                    break;
                case 8:
                    System.out.println("a.indexOf(\"a\") :" + a.indexOf("a"));
                    break;
                case 9:
                    a.replace("a","k");
                    System.out.println("a.replace(\"a\",\"k\") :" + a);
                    break;
                case 10:
                    a.replaceAt(2,"k");
                    System.out.println("a.replace(2,\"k\") :" + a);
                    break;
                case 11:
                    a.swap("c","b");
                    System.out.println("a.swap(\"c\",\"b\") :" + a);
                    break;
                case 12:
                    System.out.println("a.isEmpty() :" + a.isEmpty());
                    break;
                case 13:
                    System.out.println("a.getSize() :" + a.getSize());
                    break;
                case 14:
                    System.out.println("a.getElement() :" + a.getElement(3));
                    break;
                case 15:
                    System.out.println("a.toString() :" + a.toString());
                    break;
                default:
                    break;
            }
            System.out.println("");
        } while (userChoice >= 1 && userChoice <= 15);
    }
    
    private static void countableNumList() {
        int userChoice = 0;
        CountableNumList<String> a = new CountableNumList<String>();
        a.add(5);
        a.add(8);
        a.add(11);
        a.add(21);
        a.add(3);
        CountableNumList<String> b = new CountableNumList<String>();
        a.add(3);
        a.add(5);
        a.add(1);
        do {
            System.out.println("");
            System.out.println("------- ComparableList ADT -------");
            System.out.println("[1] clear");
            System.out.println("[2] isListFull");
            System.out.println("[3] add");
            System.out.println("[4] remove");
            System.out.println("[5] replace");
            System.out.println("[6] isEmpty");
            System.out.println("[7] getSize");
            System.out.println("[8] getNum");
            System.out.println("[9] getMax");
            System.out.println("[10] getMin");
            System.out.println("[11] getSum");
            System.out.println("[12] getMean");
            System.out.println("[13] getMode");
            System.out.println("[14] Back to previous page");
            System.out.println("Please pick one... ");
            while (!in.hasNextInt()) {
                in.next();
            }
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Before clear : " + b);
                    b.clear();
                    System.out.println("After clear  : " + b);
                    break;
                case 2:
                    System.out.println("a.isListFull():" + a.isListFull());
                    break;
                case 3:
                    a.add(9);
                    System.out.println("a.add(9) :" + a);
                    break;
                case 4:
                    a.remove(4);
                    System.out.print("a.remove(4) :" + a);
                    break;
                case 5:
                    a.replace(1,6);
                    System.out.println("a.replace(1,6) :" + a);
                    break;
                case 6:
                    System.out.println("a.isEmpty() :" + a.isEmpty());
                    break;
                case 7:
                    System.out.println("a.getSize() :" + a.getSize());
                    break;
                case 8:
                    System.out.println("a.getNum(3) :" + a.getNum(3));
                    break;
                case 9:
                    System.out.println("a.getMax() :" + a.getMax());
                    break;
                case 10:
                    System.out.println("a.getMin() :" + a.getMin());
                    break;
                case 11:
                    System.out.println("a.getSum() :" + a.getSum());
                    break;
                case 12:
                    System.out.println("a.getMean() :" + a.getMean());
                    break;
                case 13:
                    System.out.println("a.getMode() :" + a.getMode());
                    break;
                default:
                    break;
            }
            System.out.println("");
        } while (userChoice >= 1 && userChoice <= 13);
    }
    
    private static void browseEvent(){
        int identifier = 0;
        String compare = "";
        boolean status = false;
        while (status != true) {
            System.out.println("");
            System.out.println("Browse by...");
            System.out.println("[1] Event ID");
            System.out.println("[2] Event Title");
            System.out.println("Please pick one:");
            identifier = inputInt();
            switch (identifier) {
                case 1:
                    System.out.println("");
                    System.out.println("Target Event ID:");
                    compare = inputString();
                    System.out.println("");
                    System.out.println("browsing...");
                    try {
                        TimeUnit.SECONDS.sleep(DEFAULT_PROCESSING_TIME);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(eventHeading());
                    for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                        Event e = it.next();
                        if (e.getEventID().equals(compare)) {
                            System.out.println(e);
                            registration(compare);
                        }
                    }
                    status = true;
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Target Event Title:");
                    compare = inputString();
                    System.out.println("");
                    System.out.println("browsing...");
                    try {
                        TimeUnit.SECONDS.sleep(DEFAULT_PROCESSING_TIME);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(eventHeading());
                    for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                        Event e = it.next();
                        if (e.getEventTitle().equals(compare)) {
                            System.out.println(e);
                        }
                    }
                    status = true;
                    break;
                default:
                    System.out.println("No such event found");
                    status = true;
                    break;
            }
        }
        System.out.println("");
    }
        
    private static void addToAttendeeList(String identifier) {
        String ID = "";
        String Position = "";
        String compare = "";
        boolean status = false;
        while (status != true) {
            System.out.println("");
            System.out.println("Student ID:");
            ID = inputString();
            System.out.println("Position (Member/Committee/President)  :");
            Position = inputString();
            for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                Event e = it.next();
                if (e.getEventID().equals(identifier) || e.getEventTitle().equals(identifier)) {
                    e.setAttendeeList(ID);
                    e.setAttendeePosition(Position);
                    switch (Position) {
                        case "Committee":
                            e.setAttendeeCocuMarks(DEFAULT_COCU_MARK_FOR_COMMITTEE);
                            break;
                        case "President":                           
                            e.setAttendeeCocuMarks(DEFAULT_COCU_MARK_FOR_PRESIDENT);
                            break;
                        default:                          
                            e.setAttendeeCocuMarks(DEFAULT_COCU_MARK_FOR_MEMBER);
                            break;
                    }
                }
            }
            System.out.println("Add more?[Y/N]");
            compare = inputString();
            status = "N".equals(compare.toUpperCase());
        }
        System.out.println("Added to attendee list of this event");
        System.out.println("");
    }
    
    private static void registration(String identifier) {
        System.out.println("");
        System.out.println("Do you wish to register to this event?[Y/N]");
        String choice = inputString();
        if ("Y".equals(choice.toUpperCase())) {
            addToAttendeeList(identifier);
        }
    }
        
    private static void createEvent(){
        String title = "";
        String details = "";
        String venue = "";
        String date = "";
        int durationInDay = 0;
        String proceed = "";
        
        while (!"Y".equals(proceed)) {
            System.out.println("");
            System.out.println("Enter event Info: ");
            System.out.println("Title is ");
            title = inputString();
            System.out.println("Detail is");
            details = inputString();
            System.out.println("Venue is");
            venue = inputString();
            System.out.println("Date (13/02/2021) is ");
            date = inputDate();
            System.out.println("Duration (days) is"); 
            durationInDay = inputInt(); 
            System.out.println("Proceed?[Y]");
            proceed = inputString();
            proceed = proceed.toUpperCase();
        }
        System.out.println("");
        System.out.println("creating event...");
        try {
            TimeUnit.SECONDS.sleep(DEFAULT_PROCESSING_TIME);
        } catch (InterruptedException ex) {
            Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Event e = new Event(eventSeqNum++,  title,  venue,  details,  date,  durationInDay);
        eventList.add(e);
        System.out.println("Created an event");
        System.out.println("");
    }
        
    private static void editEvent(){
        int identifier = 0;
        String ID = "";
        String title = "";
        String details = "";
        String venue = "";
        String date = "";
        int durationInDay = 0;
        String proceed = "";
        String compare = "";
        boolean status = false;
        while (status != true) {
            System.out.println("");
            System.out.println("Edit by...");
            System.out.println("[1] Event ID");
            System.out.println("[2] Event Title");
            System.out.println("Please pick one:");
            identifier = inputInt();
            switch (identifier) {
                case 1:
                    System.out.println("");
                    System.out.println("Target Event ID:");
                    compare = inputString();
                    System.out.println("Enter event Info: ");
                    System.out.println("Title is ");
                    title = inputString();
                    System.out.println("Detail is");
                    details = inputString();
                    System.out.println("Venue is");
                    venue = inputString();
                    System.out.println("Date (13/02/2021) is ");
                    date = inputDate();
                    System.out.println("Duration (days) is");
                    durationInDay = inputInt();
                    for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                        Event e = it.next();
                        if (e.getEventID().equals(compare)){
                            e.setEventTitle(title);
                            e.setEventDetails(details);
                            e.setEventVenue(venue);
                            e.setEventDate(date);
                            e.setDurationInDay(durationInDay);
                        }
                    }
                    status = true;
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Target Event Title:");
                    compare = inputString();
                    System.out.println("Enter new event Info: ");
                    System.out.println("Title is ");
                    title = inputString();
                    System.out.println("Detail is");
                    details = inputString();
                    System.out.println("Venue is");
                    venue = inputString();
                    System.out.println("Date (13/02/2021) is ");
                    date = inputDate();
                    System.out.println("Duration (days) is");
                    durationInDay = inputInt();
                    for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                        Event e = it.next();
                        if (e.getEventTitle().equals(compare)){
                            e.setEventTitle(title);
                            e.setEventDetails(details);
                            e.setEventVenue(venue);
                            e.setEventDate(date);
                            e.setDurationInDay(durationInDay);
                        }
                    }
                    status = true;
                    break;
                default:
                    break;
            }
        }
        System.out.println("");
        System.out.println("updating to database...");
        try {
            TimeUnit.SECONDS.sleep(DEFAULT_PROCESSING_TIME);
        } catch (InterruptedException ex) {
            Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Event edited");
        System.out.println("");
    }
        
    private static void deleteEvent(){
        int identifier = 0;
        String compare = "";
        ComparableList<Event> tem = new ComparableList<Event>();
        boolean status = false;
        while (status != true) {
            System.out.println("");
            System.out.println("Delete by...");
            System.out.println("[1] Event ID");
            System.out.println("[2] Event Title");
            System.out.println("Please pick one:");
            identifier = inputInt();
            switch (identifier) {
                case 1:
                    System.out.println("");
                    System.out.println("Target Event ID:");
                    compare = inputString();
                    for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                        Event e = it.next();
                        if (!e.getEventID().equals(compare)) {
                            tem.add(e);
                        }
                    }
                    eventList = tem;
                    status = true;
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Target Event Title:");
                    compare = inputString();
                    for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                        Event e = it.next();
                        if (!e.getEventTitle().equals(compare)) {
                            tem.add(e);
                        }
                    }
                    eventList = tem;
                    status = true;
                    break;
                default:
                    break;
            }
        }
        System.out.println("");
        System.out.println("updating to database...");
        try {
            TimeUnit.SECONDS.sleep(DEFAULT_PROCESSING_TIME);
        } catch (InterruptedException ex) {
            Logger.getLogger(EventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Event deleted");
        System.out.println("");
    }
        
    private static void displayEventList(){
        System.out.println(eventHeading());
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            System.out.println(e);
        }
        System.out.println("");
    }
        
    private static void deleteEventList(){
        eventList.clear();
        System.out.println("");
    }
        
    private static void displayPastEvent(){
        System.out.println(eventHeading());
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            if (identifyPastEvent(e.getEventTitle()) == true) {
                System.out.println(e);
            }
        }
        System.out.println("");
    }
    
    private static String getAttendeeList(Event e){
        String result = "";
        for (int index = 1; index <= e.getAttendeeListSize(); ++index) {
            result += String.format("%-5d %-15s %-15s %-15d"
                    ,index
                    ,e.getAttendeeList(index) 
                    ,e.getAttendeePosition(index)
                    ,e.getAttendeeCocuMarks(index)) 
                    + "\n";
        }
        return result;
    }
    
    private static void displayEventListWithAttendeeList(){
        System.out.println("");
        System.out.println("Event List with Their Attendee List");
        System.out.println("-".repeat(35));
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            String toDisplay = String.format("%-16s%-15s \n%-16s%-15s \n%-16s%-15s \n%-40s\n%-40s\n%-40s\n",
                                             "ID            : ",e.getEventID(), 
                                             "Title         : ",e.getEventTitle(), 
                                             "Organisor     : ",e.getOrganisor(),
                                             "Attendee List : ",attendeeHeading(),
                                             getAttendeeList(e));
            System.out.println(toDisplay);
        }
        System.out.println("");
    }
        
    private static String eventHeading() {
        System.out.println("");
	return String.format("%-8s %-10s %-10s %-15s %-8s %-35s", 
                "ID", "Title", "Venue", "Date", "Days", "Remark") 
                + String.format("\n%-86s", 
                        repeat("-", 86));
    }
    
    private static String attendeeHeading() {
        return String.format("%-51s\n", repeat("=", 51)) + 
               String.format("%-5s %-15s %-15s %-15s\n",
                             "No.", "ID", "Position", "Cocu Mark") + 
               String.format("%-51s",repeat("=", 51));
    }
    
    private static String inputString(){
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
    }
        
    private static int inputInt(){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("invalid, enter agian");
        }
        int result = scanner.nextInt();
        return result;
    }
    
    private static String inputDate(){
        boolean status = false;
        String result = "";
        while (status != true) {
            result = inputString();
            if(isDateValid(result) != true){
                System.out.println("invalid input");
                System.out.println("Date is (13/02/2021)");
            }
            status = isDateValid(result);
        }
        return result;
    }
    
    private static boolean isDateValid(String date) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;
        try {
            testDate = df.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return df.format(testDate).equals(date);
    }
    
    private static String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    private static boolean identifyPastEvent(String title) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            try {
                if (e.getEventTitle().equals(title) && (df.parse(e.getEventDate())).before(new Date())){
                    
                    return true;
                }
            } catch (ParseException ex) {
                Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
