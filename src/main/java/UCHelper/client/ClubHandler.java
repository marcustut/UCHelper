package UCHelper.client;

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
    Welcome, Main, RegisterClub, RemoveClub, ManageClub, Club, Member, Event, RegisterNewMember, RemoveExistingMember,
    DisplayEvents, OrganizeEvent, CancelEvent, EditEvent
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

    clubManager.getClub(clubId).removeMember(studentId);

    System.out.println("\n✅ A student with [studId: " + studentRemoved.getStudID() + "] [name: "
        + studentRemoved.getName() + "] is removed");

    clubClient.goBack(sleepTime);

    // Redirect back to Member screen
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
      case Event:
        ClubHandler.eventHandler();
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
