package UCHelper.entity;

import java.util.Iterator;

import UCHelper.adt.LinkedList;

public class EventManager {
  private LinkedList<Event> events;

  public EventManager() {
    this(new LinkedList<Event>());
  }

  public EventManager(LinkedList<Event> events) {
    this.events = events;
  }

  /**
   * Getter method for events
   */
  public LinkedList<Event> getEvents() {
    return events;
  }

  /**
   * Register an event into the list of events
   * 
   * @param event - An event object to be added to the list of events
   * @return true if added successfully, false otherwise
   */
  public boolean registerEvent(Event event) {
    return events.add(event);
  }

  /**
   * Remove an existing event
   * 
   * @param eventSeqNum - the sequence number of the eventID
   * @return the removed event, null otherwise
   */
  public Event removeEvent(int eventSeqNum) {
    int found = events.findIndex(new Event(eventSeqNum));

    // Student not found
    if (found == -1)
      return null;

    return events.remove(found);
  }

  /**
   * Get an event from the manager
   * 
   * @param eventSeqNum - the sequence number of the eventID
   * @return event found in the manager, null otherwise
   */
  public Event getEvent(int eventSeqNum) {
    int found = events.findIndex(new Event(eventSeqNum));

    if (found == -1)
      return null;

    return events.get(found);
  }
}
