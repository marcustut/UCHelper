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
    Welcome, Main, RegisterClub, RemoveClub, DisplayAllClubs, ManageClub, Club, Member, Event, RegisterNewMember,
    RemoveExistingMember, DisplayAllMembers, DisplayEvents, OrganizeEvent, CancelEvent, EditEvent
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

    // TODO: This doesn't work yet, BST not support remove
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

    // TODO: Verify whether a Club with `clubId` given exists

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
    Student studentRemoved = clubManager.getClub(clubId).findMember(studentId);

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
                : (userSelection - 1) == ClubClient.EventScreenSelection.EditEvent.ordinal() ? ScreenState.EditEvent
                    : ScreenState.ManageClub;
  }

  private static void displayEventsHandler() {

    state = ScreenState.Event;
  }

  private static void organizeEventHandler() {
  }

  private static void cancelEventHandler() {
  }

  private static void editEventHandler() {
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
      case EditEvent:
        ClubHandler.editEventHandler();
        break;
      default:
        System.err.println("\nInvalid State [" + state + "]");
        exit = true;
        break;
      }

      // // Render the club screen (to know which)
      // userSelection = clubClient.clubScreen();

      // // Check which category does user select
      // if ((userSelection - 1) == ClubClient.ManageScreenSelection.Member.ordinal())
      // {
      // userSelection = clubClient.memberScreen();
      // ClubHandler.memberHandler(clubId, userSelection);
      // } else {
      // userSelection = clubClient.eventScreen();
      // }
    }

    return exit;
  }
}
