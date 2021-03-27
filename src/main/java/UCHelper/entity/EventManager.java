package UCHelper.entity;

import java.util.Iterator;
import UCHelper.adt.ComparableList;
/**
 * EventManager.java is an entity class that acts as an associative entity between club and event.
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 1.0
 */
public class EventManager{
    public static ComparableList<Event> eventList = new ComparableList<Event>();
    public static int eventSeqNum = 100;    
    
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
}
