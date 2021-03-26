package UCHelper.client;

import java.util.Iterator;
import java.util.Scanner;

import UCHelper.entity.*;
import UCHelper.adt.*;

public class ClubHandler {
  private static ClubClient clubClient;
  private static ClubManager clubManager = new ClubManager();
  private static int userSelection;
  private static int clubId;
  private static int sleepTime = 2000;
  private static ScreenState state;

  private enum ScreenState {
    Welcome, Main, RegisterClub, RemoveClub, DisplayAllClubs, ManageClub, BackToMainMenu, Club, Member, Event,
    RegisterNewMember, RemoveExistingMember, DisplayAllMembers, DisplayEvents, OrganizeEvent, CancelEvent
  }

  private static void welcomeHandler() {
    // Display the Welcome Screen
    Main.clearScreen();
    clubClient.welcomeScreen();
    // Redirect to MainScreen
    state = ScreenState.Main;
  }

  private static void mainHandler() {
    // Render the main menu
    userSelection = clubClient.mainScreen();
    // Assign the state based on userSelection
    state = (userSelection - 1) == ClubClient.MainScreenSelection.RegisterClub.ordinal() ? ScreenState.RegisterClub
        : (userSelection - 1) == ClubClient.MainScreenSelection.RemoveClub.ordinal() ? ScreenState.RemoveClub
            : (userSelection - 1) == ClubClient.MainScreenSelection.DisplayAllClubs.ordinal()
                ? ScreenState.DisplayAllClubs
                : (userSelection - 1) == ClubClient.MainScreenSelection.BackToMainMenu.ordinal()
                    ? ScreenState.BackToMainMenu
                    : ScreenState.Club;
  }

  private static void registerClubHandler() {
    // Get the clubName from user
    String clubName = clubClient.registerScreen();

    // Create a new club
    Club newClub = new Club(clubName);

    // Register a new club
    clubManager.registerClub(newClub);

    System.out
        .println("\n✅ A new club is registered with [id: " + newClub.getId() + "] [name: " + newClub.getName() + "]");

    clubClient.goBack(sleepTime);

    // Return to main after finish registering
    state = ScreenState.Main;
  }

  private static void removeClubHandler() {
    // Get the clubId from user
    int clubId = clubClient.removeScreen();

    // If club with clubId given is not found
    if (!clubManager.getClubs().contains(new Club(clubId))) {
      System.out.println("\n❌ Club with ID [" + clubId + "] not found");
      clubClient.goBack(sleepTime);
      state = ScreenState.Main;
      return;
    }

    // Remove a club
    clubManager.removeClub(clubId);

    clubClient.goBack(sleepTime);

    // Return to main after finish removing
    state = ScreenState.Main;
  }

  private static void displayAllClubsHandler() {
    Iterator<Club> itr = clubManager.getClubs().traverse(BinarySearchTree.TreeTraversalOrder.InOrderTraversal);

    int index = 1;

    Main.clearScreen();
    System.out.print("\nList of Clubs 📋\n" + ClubClient.SEPARATOR);

    while (itr.hasNext()) {
      System.out.println(index + ". [" + itr.next() + "]");
      index++;
    }

    state = ScreenState.Main;
  }

  private static void clubHandler() {
    clubId = clubClient.clubScreen();

    // If club with clubId given is not found
    if (!clubManager.getClubs().contains(new Club(clubId))) {
      System.out.println("\n❌ Club with ID [" + clubId + "] not found");
      clubClient.goBack(sleepTime);
      state = ScreenState.Main;
      return;
    }

    // Go to Manage page if clubId is valid
    state = ScreenState.ManageClub;
  }

  private static void manageClubHandler() {
    userSelection = clubClient.manageScreen();

    // Assign the state based on userSelection
    state = (userSelection - 1) == ClubClient.ManageScreenSelection.Member.ordinal() ? ScreenState.Member
        : (userSelection - 1) == ClubClient.ManageScreenSelection.Event.ordinal() ? ScreenState.Event
            : ScreenState.Main;
  }

  private static void memberHandler() {
    userSelection = clubClient.memberScreen();

    // Assign the state based on userSelection
    state = (userSelection - 1) == ClubClient.MemberScreenSelection.RegisterNewMember.ordinal()
        ? ScreenState.RegisterNewMember
        : (userSelection - 1) == ClubClient.MemberScreenSelection.RemoveExistingMember.ordinal()
            ? ScreenState.RemoveExistingMember
            : (userSelection - 1) == ClubClient.MemberScreenSelection.DisplayAllMembers.ordinal()
                ? ScreenState.DisplayAllMembers
                : ScreenState.ManageClub;
  }

  private static void registerNewMemberHandler() {
    Student newMember = clubClient.registerNewMemberScreen();

    clubManager.getClub(clubId).addMember(newMember);

    System.out.println("\n✅ A new student is registered with [studId: " + newMember.getStudID() + "] [name: "
        + newMember.getName() + "]");

    clubClient.goBack(sleepTime);

    // Redirect back to Member screen
    state = ScreenState.Member;
  }

  private static void removeExistingMemberHandler() {
    int studentId = clubClient.removeExistingMemberScreen();
    Student studentRemoved = clubManager.getClub(clubId).getMember(studentId);

    if (studentRemoved == null)
      System.out.println("\n❌ Student with studentId [" + studentId + "] is not found");
    else {
      clubManager.getClub(clubId).removeMember(studentId);
      System.out.println("\n✅ A student with [studId: " + studentRemoved.getStudID() + "] [name: "
          + studentRemoved.getName() + "] is removed");
    }

    clubClient.goBack(sleepTime);

    // Redirect back to Member screen
    state = ScreenState.Member;
  }

  private static void displayAllMembersHandler() {
    Club club = clubManager.getClub(clubId);
    Iterator<Student> itr = club.getMembers().iterator();
    int index = 1;

    while (itr.hasNext()) {
      System.out.println(index + ". [" + itr.next() + "]");
      index++;
    }

    state = ScreenState.Member;
  }

  private static void eventHandler() {
    userSelection = clubClient.eventScreen();

    // Assign the state based on userSelection
    state = (userSelection - 1) == ClubClient.EventScreenSelection.DisplayEvents.ordinal() ? ScreenState.DisplayEvents
        : (userSelection - 1) == ClubClient.EventScreenSelection.OrganizeEvent.ordinal() ? ScreenState.OrganizeEvent
            : (userSelection - 1) == ClubClient.EventScreenSelection.CancelEvent.ordinal() ? ScreenState.CancelEvent
                : ScreenState.ManageClub;
  }

  private static void displayEventsHandler() {
    Club club = clubManager.getClub(clubId);
    Iterator<Event> itr = club.getEvents().iterator();
    int index = 1;

    while (itr.hasNext()) {
      Event event = itr.next();
      System.out.printf("%d. [Event ID: %s, Title: %s, Venue: %s, Details: %s, Date: %s, DurationInDay: %d]\n", index,
          event.getEventID(), event.getEventTitle(), event.getEventVenue(), event.getEventDetails(),
          event.getEventDate(), event.getDurationInDay());
      index++;
    }

    state = ScreenState.Event;
  }

  private static void organizeEventHandler() {
    Event newEvent = clubClient.organizeEventScreen();

    boolean successful = clubManager.getClub(clubId).registerEvent(newEvent);

    if (successful) {
      System.out.println("\n✅ A new event is registered with [eventId: " + newEvent.getEventID() + "] [eventTitle: "
          + newEvent.getEventTitle() + "] [eventVenue: " + newEvent.getEventVenue() + "] [eventDetails: "
          + newEvent.getEventDetails() + "] [eventDate: " + newEvent.getEventDate() + "] [eventDurationInDay: "
          + newEvent.getDurationInDay() + "]");
    } else {
      System.out.println("\n❌ Event with ID [" + newEvent.getEventID() + "] can't be created");
    }

    clubClient.goBack(sleepTime);

    // Redirect back to Event screen
    state = ScreenState.Event;
  }

  private static void cancelEventHandler() {
    int eventSeqNum = clubClient.cancelEventScreen();
    Event eventRemoved = clubManager.getClub(clubId).getEvent(eventSeqNum);

    if (eventRemoved == null)
      System.out.println("\n❌ Event with sequence number [" + eventSeqNum + "] is not found");
    else {
      clubManager.getClub(clubId).removeEvent(eventSeqNum);
      System.out.println("\n✅ An event is canceled with [eventId: " + eventRemoved.getEventID() + "] [eventTitle: "
          + eventRemoved.getEventTitle() + "] [eventVenue: " + eventRemoved.getEventVenue() + "] [eventDetails: "
          + eventRemoved.getEventDetails() + "] [eventDate: " + eventRemoved.getEventDate() + "] [eventDurationInDay: "
          + eventRemoved.getDurationInDay() + "]");
    }

    clubClient.goBack(sleepTime);

    // Redirect back to Event screen
    state = ScreenState.Event;
  }

  /**
   * Run the ClubManager program(module) of UCHelper System
   * 
   * @param scanner - A scanner object for taking input from
   * @return true when execution is complete
   */
  public static boolean runClubManager(Scanner scanner) {
    clubClient = new ClubClient(scanner);
    state = ScreenState.Welcome;
    boolean exit = false;

    // Loop forver until user exits
    while (!exit) {
      switch (state) {
      case Welcome:
        ClubHandler.welcomeHandler();
        break;
      case Main:
        ClubHandler.mainHandler();
        break;
      case RegisterClub:
        ClubHandler.registerClubHandler();
        break;
      case RemoveClub:
        ClubHandler.removeClubHandler();
        break;
      case DisplayAllClubs:
        ClubHandler.displayAllClubsHandler();
        break;
      case Club:
        ClubHandler.clubHandler();
        break;
      case ManageClub:
        ClubHandler.manageClubHandler();
        break;
      case Member:
        ClubHandler.memberHandler();
        break;
      case RegisterNewMember:
        ClubHandler.registerNewMemberHandler();
        break;
      case RemoveExistingMember:
        ClubHandler.removeExistingMemberHandler();
        break;
      case DisplayAllMembers:
        ClubHandler.displayAllMembersHandler();
        break;
      case Event:
        ClubHandler.eventHandler();
        break;
      case DisplayEvents:
        ClubHandler.displayEventsHandler();
        break;
      case OrganizeEvent:
        ClubHandler.organizeEventHandler();
        break;
      case CancelEvent:
        ClubHandler.cancelEventHandler();
        break;
      case BackToMainMenu:
        Main.clearScreen();
        exit = true;
        continue;
      default:
        System.err.println("\nInvalid State [" + state + "]");
        exit = true;
        break;
      }
    }

    return exit;
  }
}
