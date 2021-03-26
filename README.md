# University Club Helper

This is a project for BACS2063 Data Structures and Algorithm.

## Getting started

```sh
# list the tasks you can do with gradle
./gradlew tasks

# run the unit tests
./gradlew test

# run the project
./gradlew run

# run the project with input using `System.in`
./gradlew --console plain run
```

⚠ Use `gradlew.bat` if you're on Windows.

## Builid Configuration

The entry point of the project should be defined in `build.gradle`. Gradle will not run properly if the entry point is not defined.

```gradle
...
mainClassName = 'UCHelper.client.Main'
...
```

## Usage

To help a club to manage their community

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Lecturer

## Event

Created a eventHandler UI and event entity for event module, successfully implement comparableList.java, countableNumList.java and their interface for storing numerous events and events'attendees.

## Club

### Responsibilities 📝

#### 1. To manage a collection of clubs

- Registering a new club
- Deleting an existing club
- View the list of active clubs

#### 2. To manage students in a Club

- Adding a new student to a club
- Removing an existing student from a club
- Display all the students in a club

#### 3. To manage events of a Club

- Schedule a new event for a club
- Deleting a scheduled event for a club
- Display all the scheduled events of a club

### ADT (Abstract Data Type) 🧩

1. BinarySearchTree (BinarySearchTree.java, Tree.java)
2. LinkedListStack (LinkedListStack.java)

A special use case here for **LinkedListStack** here is that it is used for constructing an iterator of the traversal of BST (BinarySearchTree)

### Unit Tests 🧰

The unit tests for ADT used are specified in `src/test/UCHelper/adt`. The purpose of writing unit tests is to make sure ADTs are working correctly before using them in the entity class. Else, it might cause unobvious errors which are hard to debug.

### Clients 💻

1. ClubHandler.java
2. ClubClient.java

`ClubHandler.java` handles the application's state and registering respective handlers for each states. Therefore, redirection is handled here.

Below are some code snippets to explain how it works.

#### Declaring states in the app

```java
  ...
  // This enum is to store every possible states in the app
  private enum ScreenState {
    Welcome, Main, RegisterClub, RemoveClub, DisplayAllClubs, ManageClub, BackToMainMenu, Club, Member, Event,
    RegisterNewMember, RemoveExistingMember, DisplayAllMembers, DisplayEvents, OrganizeEvent, CancelEvent
  }
  ...
```

#### Registering handler for each state

```java
    ...
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
    ...
```

As you can see, each state will have its own respective handler.

#### Writing a handler

```java
  ...
  private static void welcomeHandler() {
    // Clear the console before displaying
    Main.clearScreen();
    // Display the Welcome Screen
    clubClient.welcomeScreen();
    // Redirect to MainScreen
    state = ScreenState.Main;
  }
  ...
```

So, in this handler it will do its thing, and after it's done, it will redirect to another state.

#### Redirect to another state

```java
  ...
  state = ScreenState.Main;
  ...
```

To redirect another state, it is very simple, just assign the `state` variable with a value declared in the enum previously.

`ClubClient.java` handles the user interaction (input/output). Therefore, error handling for user input all done here.

#### An example of a client method

```java
  ...
  public int mainScreen() {
    String instruction = "\nWhat do you want to do?\n";
    String selection = "[1] Register a new club 📝\n" + "[2] Remove an existing club ❌\n" + "[3] Display all clubs 📋\n"
        + "[4] Manage a club 💻\n" + "[5] Back to Main Menu ⏪\n";
    String mainScreen = instruction + selection + SEPARATOR + inputPrefix;
    int userSelection = 0;
    boolean continuePrompt = true;

    do {
      try {
        // Prompt the user for clubId
        System.out.print(mainScreen);

        userSelection = scanner.nextInt();

        while (userSelection < 1 || userSelection > 5) {
          // Prompt the user for selection
          Main.clearScreen();
          System.out.println("\nYou can only enter selection from '1 - 5', try again.\n");
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
  ...
```

## Student
