package UCHelper.entity;

import UCHelper.adt.ComparableList;
import UCHelper.adt.CountableNumList;
/**
 * Event.java An entity class that stored a proposed event of a club.
 * @author Dennis Lau Yik Ann RSFY2S2, dennislauyikann@gmail.com
 * @version 3.0
 */
public class Event implements Comparable<Event> {

    // data declaration
    private String eventID;
    private String eventTitle;
    private String eventDetails;
    private String eventVenue;
    private String eventDate;
    private int durationInDay;
    private String organisor;
    private ComparableList<String> attendeeList = new ComparableList<String>();
    private ComparableList<String> attendeePosition = new ComparableList<String>();
    private CountableNumList<String> attendeeCocuMarks = new CountableNumList<String>();
    
    // constructor
    public Event() {
    }

    public Event(int eventSeqNum) {
        this.eventID = "E-" + eventSeqNum;
    }

    public Event(int eventSeqNum, String eventTitle, String eventVenue, String eventDetails, String eventDate,
            int durationInDay) {
        this.eventID = "E-" + eventSeqNum;
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

    public void setEventID(String eventID) {
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

    public String getOrganisor() {
        return organisor;
    }

    public void setOrganisor(String ClubID) {
        this.organisor = ClubID;
    }

    public int getAttendeeListSize() {
        return attendeeList.getSize();
    }
    
    public String getAttendeeList(int index) {
        return attendeeList.getElement(index);
    }

    public String getAttendeePosition(int index) {
        return attendeePosition.getElement(index);
    }

    public int getAttendeeCocuMarks(int index) {
        return attendeeCocuMarks.getNum(index);
    }
    
    public void setAttendeeList(String studentID) {
        this.attendeeList.add(studentID);
    }
    
    public void setAttendeePosition(String position) {
        this.attendeePosition.add(position);
    }
    
    public void setAttendeeCocuMarks(int cocu_Mark) {
        this.attendeeCocuMarks.add(cocu_Mark);
    }
    
    @Override
    public String toString() {
        return String.format("%-8s %-10s %-10s %-15s %-8d %-35s", 
                eventID, eventTitle, eventVenue, eventDate,
                durationInDay, eventDetails);
    }

    @Override
    public int compareTo(Event anotherEvent) {
        return getEventID().compareTo(anotherEvent.getEventID());
    }
}
