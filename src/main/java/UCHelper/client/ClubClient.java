package UCHelper.client;

import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import UCHelper.entity.Student;

public class ClubClient {
  public final static String SEPARATOR = String.format("%75s\n", " ").replace(' ', '-');
  public final static String SHORT_SEPARATOR = String.format("%31s", " ").replace(' ', '-');
  public static Scanner scanner;
  public static char inputPrefix;
  private SimpleDateFormat dateFormat;

  public enum MainScreenSelection {
    RegisterClub, RemoveClub, DisplayAllClubs, ManageClub
  }

  public enum ManageScreenSelection {
    Member, Event, GoBack
  }

  public enum MemberScreenSelection {
    RegisterNewMember, RemoveExistingMember, DisplayAllMembers, GoBack
  }

  public enum EventScreenSelection {
    DisplayEvents, OrganizeEvent, CancelEvent, EditEvent, GoBack
  }

  public ClubClient(Scanner scanner) {
    this('>', new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy(E)"), scanner);
  }

  public ClubClient(char prefix, SimpleDateFormat dateFormat, Scanner scanner) {
    ClubClient.inputPrefix = prefix;
    this.dateFormat = dateFormat;
    ClubClient.scanner = scanner;
  }

  public void welcomeScreen() {
    String logo = "\n"

        + "  _____ _       _       __  __                                   \n"
        + " / ____| |     | |     |  \\/  |                                  \n"
        + "| |    | |_   _| |__   | \\  / | __ _ _ __   __ _  __ _  ___ _ __ \n"
        + "| |    | | | | | '_ \\  | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '__|\n"
        + "| |____| | |_| | |_) | | |  | | (_| | | | | (_| | (_| |  __/ |   \n"
        + " \\_____|_|\\__,_|_.__/  |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|   \n"
        + "                                                  __/ |          \n"
        + "                                                 |___/           \n";

    String welcome = "\nWelcome to UCHelper's Club Manager, we're happy to serve!\uD83D\uDE03";

    System.out.println(logo + welcome);
  }

  public int mainScreen() {
    String instruction = "\nWhat do you want to do?\n";
    String selection = "1. Register a new club\n" + "2. Remove an existing club\n" + "3. Display all clubs\n"
        + "4. Manage a club\n";
    String mainScreen = instruction + selection + SEPARATOR + inputPrefix;
    int userSelection = 0;
    boolean continuePrompt = true;

    do {
      try {
        // Prompt the user for clubId
        System.out.print(mainScreen);

        userSelection = scanner.nextInt();

        while (userSelection < 1 || userSelection > 4) {
          // Prompt the user for selection
          Main.clearScreen();
          System.out.println("\nYou can only enter selection from '1 - 4', try again.\n");
          System.out.print(mainScreen);

          // Take input from user
          userSelection = scanner.nextInt();
        }

        continuePrompt = false;
      } catch (InputMismatchException ex) {
        System.out.println(this.errorMessage(ex) + '\n');
        scanner.nextLine();
      }
    } while (continuePrompt);

    return userSelection;
  }

  public String registerScreen() {
    String instruction = "\nEnter the club name that you want to register\n";
    String registerScreen = instruction + inputPrefix;
    String input = "";
    boolean continuePrompt = true;

    do {
      System.out.print(registerScreen);

      // Just to clean the stream
      scanner.nextLine();
      input = scanner.nextLine();

      // If empty input
      while (input.equals("")) {
        // Prompt the user for club name
        Main.clearScreen();
        System.out.println("\nPlease enter a name, try again.\n");
        System.out.print(registerScreen);

        // Take input from user
        input = scanner.nextLine();
      }

      continuePrompt = false;
    } while (continuePrompt);

    return input;
  }

  public int removeScreen() {
    String instruction = "\nEnter the Club ID that you want to remove\n";
    String removeScreen = instruction + inputPrefix;
    int input = 0;
    boolean continuePrompt = true;

    do {
      try {
        System.out.print(removeScreen);

        input = scanner.nextInt();

        // TODO: Validate whether club with clubId exist
        while (input < 1 || input > 49) {
          // Prompt the user for clubId
          Main.clearScreen();
          System.out.println("\nClub ID is only valid from '1 - 49', try again.\n");
          System.out.print(removeScreen);

          // Take input from user
          input = scanner.nextInt();
        }

        continuePrompt = false;
      } catch (InputMismatchException ex) {
        System.out.println(this.errorMessage(ex) + '\n');
        scanner.nextLine();
      }
    } while (continuePrompt);

    return input;
  }

  public int clubScreen() {
    String instruction = "\nPlease enter the Club's ID to manage the club ⌨:\n";
    String clubScreen = instruction + inputPrefix;
    int input = 0;
    boolean continuePrompt = true;

    do {
      try {
        // Prompt the user for clubId
        System.out.print(clubScreen);

        input = scanner.nextInt();

        // TODO: Validate whether club with clubId exist
        while (input < 1 || input > 49) {
          // Prompt the user for clubId
          Main.clearScreen();
          System.out.println("\nClub ID is only valid from '1 - 49', try again.\n");
          System.out.print(clubScreen);

          // Take input from user
          input = scanner.nextInt();
        }

        continuePrompt = false;
      } catch (InputMismatchException ex) {
        System.out.println(this.errorMessage(ex) + '\n');
        scanner.nextLine();
      }
    } while (continuePrompt);

    return input;
  }

  public int manageScreen() {
    String instruction = "\nWhich aspect of the club that you want to manage?\n";
    String selection = "1. Member 👦\n" + "2. Event 📆\n" + "3. Go back ⏪\n";
    String manageScreen = instruction + selection + SEPARATOR + inputPrefix;

    int userSelection = 0;
    boolean continueInput = true;

    // Validate user input
    do {
      try {
        // Render the manageScreen
        System.out.print(manageScreen);

        userSelection = scanner.nextInt();

        while (userSelection < 1 || userSelection > 3) {
          // Prompt the user for selection
          Main.clearScreen();
          System.out.println("\nYou can only enter selection from '1 - 3', try again.\n");
          System.out.print(manageScreen);

          // Take input from user
          userSelection = scanner.nextInt();
        }

        continueInput = false;
      } catch (InputMismatchException ex) {
        System.out.println(this.errorMessage(ex) + '\n');
        scanner.nextLine();
      }
    } while (continueInput);

    return userSelection;
  }

  public int memberScreen() {
    String instruction = "\nWhat actions do you want to perform?\n";
    String selection = "1. Register a new member 👦\n" + "2. Remove an existing member ❌\n"
        + "3. Display all members \n" + "4. Go back ⏪\n";
    String memberScreen = instruction + selection + SEPARATOR + inputPrefix;

    int userSelection = 0;
    boolean continueInput = true;

    // Validate user input
    do {
      try {
        // Render the memberScreen
        System.out.print(memberScreen);

        userSelection = scanner.nextInt();

        while (userSelection < 1 || userSelection > 4) {
          // Prompt the user for selection
          Main.clearScreen();
          System.out.println("\nYou can only enter selection from '1 - 4', try again.\n");
          System.out.print(memberScreen);

          // Take input from user
          userSelection = scanner.nextInt();
        }

        continueInput = false;
      } catch (InputMismatchException ex) {
        System.out.println(this.errorMessage(ex) + '\n');
        scanner.nextLine();
      }
    } while (continueInput);

    return userSelection;
  }

  public Student registerNewMemberScreen() {
    String instruction = "\nEnter the student details below:\n";
    String studentNamePrompt = "Student Name: ";
    String studentIdPrompt = "Student ID: ";
    String studentName = "";
    int studentId = 0;
    boolean continuePrompt = true;

    do {
      try {
        System.out.print(instruction + studentNamePrompt);

        scanner.nextLine(); // Just to clean the stream
        studentName = scanner.nextLine();

        while (studentName.equals("")) {
          // Prompt the user for student name
          Main.clearScreen();
          System.out.println("\nPlease enter a valid student name, try again.\n");
          System.out.print(instruction + studentNamePrompt);

          // Take input from user
          studentName = scanner.nextLine();
        }

        System.out.print(studentIdPrompt);

        while (scanner.hasNext()) {
          if (scanner.hasNextInt()) {
            studentId = scanner.nextInt();
            break;
          } else
            scanner.next(); // Discard other values in the stream
        }

        while (!verifyStudentId(studentId)) {
          // Prompt the user for student id
          Main.clearScreen();
          System.out.println("\nPlease enter a valid student id (must be a positive integer), try again.\n");
          System.out.print(studentIdPrompt);

          // Take input from user
          studentId = scanner.nextInt();
        }

        continuePrompt = false;
      } catch (InputMismatchException ex) {
        System.out.println(this.errorMessage(ex) + '\n');
        scanner.nextLine();
      }
    } while (continuePrompt);

    return new Student(studentName, studentId);
  }

  public int removeExistingMemberScreen() {
    String instruction = "\nEnter the student's Student ID that you would like to remove: \n";
    String removeExistingMemberScreen = instruction + SEPARATOR + inputPrefix;
    int studentId = 0;
    boolean continuePrompt = true;

    do {
      try {
        System.out.print(removeExistingMemberScreen);

        studentId = scanner.nextInt();

        while (!verifyStudentId(studentId)) {
          // Prompt the user for student id
          Main.clearScreen();
          System.out.println("\nPlease enter a valid student id (must be a positive integer), try again.\n");
          System.out.print(removeExistingMemberScreen);

          // Take input from user
          studentId = scanner.nextInt();
        }

        continuePrompt = false;
      } catch (InputMismatchException ex) {
        System.out.println(this.errorMessage(ex) + '\n');
        scanner.nextLine();
      }
    } while (continuePrompt);

    return studentId;
  }

  public int eventScreen() {
    String instruction = "\nWhat actions do you want to perform?\n";
    String selection = "1. Display the list of events 📋\n" + "2. Organize a new event ➕\n" + "3. Cancel an event ❌\n"
        + "4. Edit an event 📝\n" + "5. Go back ⏪\n";
    String eventScreen = instruction + selection + SEPARATOR + inputPrefix;

    int userSelection = 0;
    boolean continueInput = true;

    // Validate user input
    do {
      try {
        // Render the eventScreen
        System.out.print(eventScreen);

        userSelection = scanner.nextInt();

        while (userSelection < 1 || userSelection > 5) {
          // Prompt the user for selection
          Main.clearScreen();
          System.out.println("\nYou can only enter selection from '1 - 5', try again.\n");
          System.out.print(eventScreen);

          // Take input from user
          userSelection = scanner.nextInt();
        }

        continueInput = false;
      } catch (InputMismatchException ex) {
        System.out.println(this.errorMessage(ex) + '\n');
        scanner.nextLine();
      }
    } while (continueInput);

    return userSelection;
  }

  private void printGoBackMessage(int milliseconds) {
    System.out.printf("\n⏪ Going back in %d seconds...", milliseconds / 1000);
  }

  public void goBack(int sleepTime) {
    try {
      printGoBackMessage(sleepTime);
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Main.clearScreen();
  }

  private boolean verifyStudentId(int studentId) {
    return studentId > 0;
  }

  public String errorMessage(Exception ex) {
    String errorMsg = null;

    if (ex.toString().contains("InputMismatchException")) {
      errorMsg = "\nYou're not inputting an integer, try again.";
    } else {
      errorMsg = "\nYour input is incorrect. Try again.";
    }

    return errorMsg;
  }
}
