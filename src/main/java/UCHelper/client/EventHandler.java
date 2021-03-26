package UCHelper.client;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Date;

import UCHelper.adt.ComparableList;
import UCHelper.entity.*;

/**
 * EventManager.java is an client class that contain all the needed methods of
 * an event interface.
 * 
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 3.0
 */
public class EventHandler {
    static ComparableList<Event> eventList = new ComparableList<Event>();
    static Scanner in = new Scanner(System.in);
    static int eventSeqNum = 100;

    public static void EventUI() {
        testData();
        int userChoice = 0;
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
            System.out.println("What you wish to do? ");
            while (!in.hasNextInt()) {
                in.next();
                System.out.print("\nSelect [1/2/3/4/5/6/7/8/9]");
            }
            userChoice = in.nextInt();
            switch (userChoice) {
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
                break;
            }
        } while (userChoice >= 1 && userChoice <= 8);
    }

    public static void browseEvent() {
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
                System.out.println(eventHeading());
                for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                    Event e = it.next();
                    if (e.getEventID().equals(compare)) {
                        System.out.println(e);
                    }
                }
                status = true;
                break;
            case 2:
                System.out.println("");
                System.out.println("Target Event Title:");
                compare = inputString();
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

    public static void createEvent() {
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
        Event e = new Event(eventSeqNum++, title, venue, details, date, durationInDay);
        eventList.add(e);
        System.out.println("Created an event");
        System.out.println("");
    }

    public static void editEvent() {
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
                    if (e.getEventID().equals(compare)) {
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
                    if (e.getEventTitle().equals(compare)) {
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
        System.out.println("Event edited");
        System.out.println("");
    }

    public static void deleteEvent() {
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
        System.out.println("Event deleted");
        System.out.println("");
    }

    public static void displayEventList() {
        System.out.println(eventHeading());
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            System.out.println(e);
        }
        System.out.println("");
    }

    public static void deleteEventList() {
        eventList.clear();
        System.out.println("");
    }

    public static void displayPastEvent() {
        System.out.println(eventHeading());
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            if (identifyPastEvent(e.getEventTitle()) == true) {
                System.out.println(e);
            }
        }
        System.out.println("");
    }

    public static void displayEventListWithAttendeeList() {
        System.out.println("");
        System.out.println("Event List with Their Attendee List");
        System.out.println("-".repeat(35));
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            String toDisplay = String.format("%-15s%-15s \n%-15s%-15s \n%-15s%-15s \n%-40s\n%-40s", "ID            :",
                    e.getEventID(), "Title         :", e.getEventTitle(), "Organisor     :", e.getOrganisor(),
                    "Attendee List :", e.getAttendeeList());
            System.out.println(toDisplay);
        }
        System.out.println("");
    }

    public static void addToAttendeeList(String identifier) {
        String ID = "";
        String compare = "";
        boolean status = false;
        while (status != true) {
            System.out.println("");
            System.out.println("Student ID:");
            ID = inputString();
            for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                Event e = it.next();
                if (e.getEventID().equals(identifier) || e.getEventTitle().equals(identifier)) {
                    e.setAttendeeList(ID);
                }
            }
            System.out.println("Add more?[Y/N]");
            compare = inputString();
            if (compare.toUpperCase() == "N") {
                status = true;
            } else {
                status = false;
            }
        }
        System.out.println("Added to attendee list of this event");
        System.out.println("");
    }

    public static String eventHeading() {
        System.out.println("");
        return String.format("%-8s %-10s %-10s %-15s %-8s %-35s", "ID", "Title", "Venue", "Date", "Days", "Remark")
                + String.format("\n%-86s", EventHandler.repeat("-", 86));
    }

    public static String inputString() {
        Scanner in = new Scanner(System.in);
        String result = in.nextLine();
        return result;
    }

    public static int inputInt() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("invalid, enter agian");
        }
        int result = in.nextInt();
        return result;
    }

    public static String inputDate() {
        boolean status = false;
        String result = "";
        while (status != true) {
            result = inputString();
            if (isDateValid(result) != true) {
                System.out.println("invalid input");
                System.out.println("Date is (13/02/2021)");
            }
            status = isDateValid(result);
        }
        return result;
    }

    public static boolean isDateValid(String date) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;
        try {
            testDate = df.parse(date);
        } catch (ParseException e) {
            return false;
        }
        if (!df.format(testDate).equals(date)) {
            return false;
        } else {
            return true;
        }
    }

    public static String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean identifyPastEvent(String title) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            try {
                if (e.getEventTitle().equals(title) && (df.parse(e.getEventDate())).before(new Date())) {

                    return true;
                }
            } catch (ParseException ex) {
                Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static boolean testData() {
        // ---addEvent(...)
        Event e1 = new Event(eventSeqNum++, "event1", "Wangsa", "a fund raising event", "08/02/2020", 4);
        Event e2 = new Event(eventSeqNum++, "event2", "Aeon", "a fund raising event", "07/05/2021", 5);
        Event e3 = new Event(eventSeqNum++, "event3", "TAR UC", "a fund raising event", "05/03/2021", 5);
        e1.setOrganisor("C-100");
        e2.setOrganisor("C-121");
        e3.setOrganisor("C-154");

        e1.setAttendeeList("19WMR11944");
        e1.setAttendeeList("19WMR11933");
        e1.setAttendeeList("19WMR11924");
        e2.setAttendeeList("18WMR11934");
        e2.setAttendeeList("18WMR11925");
        eventList.add((Event) e1);
        eventList.add((Event) e2);
        eventList.add((Event) e3);
        System.out.println(eventHeading());
        for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
            Event e = it.next();
            System.out.println(e);
        }
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
            if (e.getEventID().equals(ID)) {
                event = e;
                return event;
            }
        }
        return null;
    }
}
