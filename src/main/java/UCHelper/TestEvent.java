package UCHelper;

import Entity.Event;
import static UCHelper.EventManager.eventList;
import java.util.Iterator;
import java.util.Scanner;
/**
 * TestEvent.java An test class that test event class, interface and ADT.
 * @author Dennis
 * @version 1.0
 */
public class TestEvent {
    public static void testEvent(){
        System.out.println("\n".repeat(2));
        System.out.println("========================");
        System.out.println("|| Event Test Session ||");
        System.out.println("========================");
        int eventSeqNum = 100;
        int spacing = 1;
        
        //---addEvent(...)
        System.out.println("\n".repeat(spacing));
        EventManager e1 = new Event();
        EventManager e2 = new Event();
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
        
        //---displayEvent(...)
        System.out.println("\n".repeat(spacing));
        System.out.println("\n" + e1.eventHeading());
        System.out.println(e1.displayEvent("event1"));
        
        //---deleteEvent(...)
        System.out.println("\n".repeat(spacing));
        System.out.println("\n" + e1.eventHeading());
        System.out.println(e1.deleteEvent("event1"));
        
        //---changeEventDate(...)
        System.out.println("\n".repeat(spacing));
        e1.changeEventDate("event2", "02/01/2021");
        System.out.println("\n" + e1.eventHeading());
        System.out.println(e1.displayEvent("event2"));
        
        //---identifyPastEvent(...)
        System.out.println("\n".repeat(spacing));
        System.out.println(e1.identifyPastEvent("event2"));
        
        //---editEvent(...)
        System.out.println("\n".repeat(spacing));
        e1.editEvent("E-103", "event6", "venue", "details", "11/03/2021", 2);
        System.out.println(e1.displayEvent("E-103"));
        
        
        //---displayParticipantList(...)
        //System.out.println("\n".repeat(spacing));
        
        
        //---displayOrganisor(...)
        //System.out.println("\n".repeat(spacing));
        
        //---publishToDiscord(...)
        //System.out.println("\n".repeat(spacing));
    }
    
    public static void main(String[] args)throws InterruptedException {
        Scanner in = new Scanner(System.in);
        testEvent();
    }
}
