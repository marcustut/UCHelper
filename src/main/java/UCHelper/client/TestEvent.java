package UCHelper.client;

import UCHelper.entity.*;
import java.util.Iterator;

import static UCHelper.entity.EventManager.eventList;

/**
 * TestEvent.java An test class that test event class, interface and ADT.
 * @author Dennis
 * @version 1.0
 */
public class TestEvent {
    public static String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times; i++) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void testEvent(){
        System.out.println(repeat("\n", 2));
        System.out.println("========================");
        System.out.println("|| Event Test Session ||");
        System.out.println("========================");
        int eventSeqNum = 100;
        int spacing = 1;
        
        //---addEvent(...)
        repeat("\n", spacing);
        EventManager e1 = (EventManager) new Event();
        EventManager e2 = (EventManager) new Event();
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
        repeat("\n", spacing);
        System.out.println("\n" + e1.eventHeading());
        System.out.println(e1.displayEvent("event1"));
        
        //---deleteEvent(...)
        repeat("\n", spacing);
        System.out.println("\n" + e1.eventHeading());
        System.out.println(e1.deleteEvent("event1"));
        
        //---changeEventDate(...)
        repeat("\n", spacing);
        e1.changeEventDate("event2", "02/01/2021");
        System.out.println("\n" + e1.eventHeading());
        System.out.println(e1.displayEvent("event2"));
        
        //---identifyPastEvent(...)
        repeat("\n", spacing);
        System.out.println(e1.identifyPastEvent("event2"));
        
        //---editEvent(...)
        repeat("\n", spacing);
        e1.editEvent("E-103", "event6", "venue", "details", "11/03/2021", 2);
        System.out.println(e1.displayEvent("E-103"));
        
        
        //---displayParticipantList(...)
        //repeat("\n", spacing);
        
        
        //---displayOrganisor(...)
        //repeat("\n", spacing);
        
        //---publishToDiscord(...)
        //repeat("\n", spacing);
    }
}
