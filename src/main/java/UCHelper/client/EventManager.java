package UCHelper.client;

//import ADT.ListInterface;
//import ADT.ArrayList;
import UCHelper.entity.*;
import UCHelper.client.UCHelper;
import UCHelper.entity.Event;

import java.util.List;
import java.util.ArrayList;
/**
 * EventManager.java is an entity class that contain all the needed methods of an event interface.
 * @author Dennis
 * @version 1.0
 */
public interface EventManager<E>{
    List<Event> eventList = new ArrayList<Event>();
    //ListInterface<Event> eventList = new ArrayList<>();
    
    String eventHeading();
    boolean addEvent(int eventSeqNum, String eventTitle, String eventVenue, String eventDetails, 
            String eventDate, int durationInDay);
    Event displayEvent(String title);
    Event displayEventFromID(String id);
//    String displayEventParticipant(String title);
//    String displayEventCrew(String title);
//    String displayEventOrganisor(String title);
//    String addToEventParticipant(Student participants);
//    String addToEventCrew(Student participants);
//    String addToEventOrganisor(Club title);
    boolean identifyPastEvent(String title);
    boolean deleteEvent(String title);
    boolean changeEventDate(String title, String date);
    boolean editEvent(String id, String eventTitle, String eventVenue, String eventDetails, 
            String eventDate, int durationInDay);
}
