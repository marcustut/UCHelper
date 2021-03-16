package UCHelper.entity;

import UCHelper.client.TestEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Event.java An entity class that stored a proposed event of a club.
 * @author Dennis
 * @version 2.0
 */
public class Event implements EventManager {

    // data declaration
    private String eventID;
    private String eventTitle;
    private String eventDetails;
    private String eventVenue;
    private String eventDate;
    private int durationInDay;
//    private Club organisor;
//    List<Student> attendeeList = new ArrayList<>();
//    List<Student> crewList = new ArrayList<>();

    // constructor
    public Event() {
    }

    public Event(int eventSeqNum, String eventTitle, String eventVenue, String eventDetails, 
            String eventDate, int durationInDay) {
        this.eventID = "E-" + eventSeqNum++;
	this.eventTitle = eventTitle;
	this.eventVenue = eventVenue;
	this.eventDetails = eventDetails;
	this.eventDate = eventDate;
	this.durationInDay = durationInDay;
    }
    
    // getter and setter
    public String getEventID() {
	return eventID;
    }

    public void setEventID() {
	this.eventID = eventID;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getDurationInDay() {
        return durationInDay;
    }

    public void setDurationInDay(int durationInDay) {
        this.durationInDay = durationInDay;
    }
    
    @Override
    public String toString() {
	return String.format("%-8s %-10s %-10s %-15s %-8d %-35s", eventID, eventTitle, eventVenue, eventDate, durationInDay, eventDetails);
    }        

    @Override
    public String eventHeading() {
	return String.format("%-8s %-10s %-10s %-15s %-8s %-35s", 
                "ID", "Title", "Venue", "Date", "Days", "Remark") 
                + String.format("\n%-86s", 
                        TestEvent.repeat("-", 86));
    }

    @Override
    public boolean addEvent(int eventSeqNum, String title, String venue, String details, String date, int duration) {
        if(isDateValid(date)){
            this.eventDate = date;
        }
        else{
            return false;
        }
        this.eventID = "E-" + eventSeqNum++;
	this.eventTitle = title;
	this.eventVenue = venue;
	this.eventDetails = details;
	this.durationInDay = duration;
        return true;
    }

    @Override
    public Event displayEvent(String title) {
        Event result = subset(title);
        return result;
    }
    
    @Override
    public Event displayEventFromID(String id) {
        Event result = subset(id);
        return result;
    }
    
    @Override
    public boolean identifyPastEvent(String title) {
        Event resultEvent;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for(Event eve : eventList){
            try {
                if (eve.eventTitle.equals(title) && (df.parse(eve.eventDate)).before(new Date())){
                    
                    return true;
                }
            } catch (ParseException ex) {
                Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    @Override
    public boolean deleteEvent(String title) {
        Event result = subset(title);
        eventList.remove(result);
        return true;
    }

    @Override
    public boolean changeEventDate(String title, String date) {
        Event result = subset(title);
        if(isDateValid(date)){
            result.eventDate = date;
        }
        return true;
    }
    
    public boolean isDateValid(String date){
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
    
    private boolean contain(String title) {
        for(Event eve : eventList){
            if (eve.eventTitle.equals(title)){
                return true;
            }
        }
        return false;
    }

    private Event subset(String title) {
        Event resultEvent = null;
        for(Event eve : eventList){
            if (eve.eventTitle.equals(title)||eve.eventID.equals(title)){
                resultEvent = eve;
                return eve;
            }
        }
        return resultEvent;
    }

    @Override
    public boolean editEvent(String id, String title, String venue, String details, String date, int duration) {
        for(Event eve : eventList){
            if (eve.eventID.equals(id)){
                eve.eventTitle = title;
                eve.eventVenue = venue;
                eve.eventDetails = details;
                eve.eventDate = date;
                eve.durationInDay = duration;
            }
        }
        return true;
    }
    
//    @Override
//    public String displayEventParticipant(String title) {
//        String pList = null;
//        for(Event eve : eventList){
//            if (eve.eventTitle.equals(title)){
//                pList = "" + eve.participantList;
//            }
//        }
//        return pList;
//    }
//
//    @Override
//    public String displayEventCrew(String title) {
//        String cList = null;
//        for(Event eve : eventList){
//            if (eve.eventTitle.equals(title)){
//                cList = "" + eve.crewList;
//            }
//        }
//        return cList;
//    }
//
//    @Override
//    public String displayEventOrganisor(String title) {
//        String o = null;
//        for(Event eve : eventList){
//            if (eve.eventTitle.equals(title)){
//                o = eve.organisor.getName();
//            }
//        }
//        return o;
//    }
//    
//    @Override
//    public boolean addToEventParticipant(Student participant) {
//        participantList.add(participant);
//        return true;
//    }
//
//    @Override
//    public boolean addToEventCrew(Student crew) {
//        crewList.add(crew);
//        return true;
//    }
//
//    @Override
//    public boolean addToEventOrganisor(Club club) {
//        this.organisor = club;
//        return true;
//    }
}
