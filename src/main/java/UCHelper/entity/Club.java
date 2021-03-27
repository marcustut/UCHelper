package UCHelper.entity;

import java.util.Date;

import UCHelper.adt.*;
import UCHelper.client.*;

public class Club implements Comparable<Club> {
    private int id;
    private String name;
    private EventHandler eventHandler = new EventHandler();
    private MemberHandler memberHandler = new MemberHandler();
    public static int index = 1;

    // REMARK: This is just for finding club with same id
    // Do not create a Club with this constructor
    public Club(int id) {
        this.id = id;
    }

    public Club(String name) {
        this.id = index;
        this.name = name;
        index++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Compare two clubs based on their ids.
     * 
     * @param anotherClub - the club to be compared with
     * @return 0 if equal, negative integer if lesser, positive integer if greater
     */
    @Override
    public int compareTo(Club anotherClub) {
        return getId() - anotherClub.getId();
    }

    @Override
    public String toString() {
        return String.format("Club ID: %d, Club Name: %s", this.id, this.name);
    }

    /**
     * Add a student to the list of members
     * 
     * @param member - the student to add
     * @return true if student is added, false otherwise
     */
    public boolean addMember(Student member) {
        return memberHandler.addMember(member);
    }

    /**
     * Remove a student from the list of members
     * 
     * @param studentId - the student id of the student to remove
     * @return true if student is removed, false otherwise
     */
    public boolean removeMember(int studentId) {
        Student result = memberHandler.removeMember(studentId);
        return result != null;
    }

    /**
     * Add an event to the list of events
     * 
     * @param event - the event to add
     * @return true if event is added, false otherwise
     */
    public boolean registerEvent(Event event) {
        return eventHandler.registerEvent(event);
    }

    /**
     * Remove an event from the list of events
     * 
     * @param eventSeqNum - the sequence number of the event
     * @return true if event is removed, false otherwise
     */
    public boolean removeEvent(int eventSeqNum) {
        Event result = eventHandler.removeEvent(eventSeqNum);
        return result != null;
    }

    /**
     * Get the list of members
     * 
     * @return list of members
     */
    public IterableCustomStack<Student> getMembers() {
        return memberHandler.getMembers();
    }

    public ComparableList<Event> getEvents() {
        return eventHandler.getEvents();
    }

    /**
     * Find a student in the list of members provided its student id
     * 
     * @param studentId - the student id of the student
     * @return the student found, null otherwise
     */
    public Student getMember(int studentId) {
        return memberHandler.getMember(studentId);
    }

    /**
     * Find an event in the list of events provided its sequence number
     * 
     * @param eventSeqNum - the sequence number of the event
     * @return
     */
    public Event getEvent(int eventSeqNum) {
        return eventHandler.getEvent(eventSeqNum);
    }
}
