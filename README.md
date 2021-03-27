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
### Responsibilities 📝
#### 1. Manage a set of lecturer information

    - Register a new lecturer
    - Delete an existing lecturer
    - View lecturer information
    - check lecturer existence in system
### ADT (Abstract Data Type)🧩
    - SetArray(SetInterface.java, Set.java)

### Clients 💻
    -  ManageLecturer.java

### How-to's 📝 
#### a. Add lecturer
1. press '1' and click 'Enter'.
2. keyed in the information.
3. enter 'y' to continue add lecturer or 'n' to main lecturer menu. 
#### b. display lecturer
1. press '2' and click 'Enter'.
2. enter 'y' to continue display lecturer or 'n' to main lecturer menu. 
#### c. remove lecturer
1. press '3' and click 'Enter'.
2. keyed in the information intended to remove.
3. enter 'y' to continue remove lecturer or 'n' to main lecturer menu. 
#### d. check lecturer
1. press '4' and click 'Enter'.
2. keyed in the information intended to check.
3. enter 'y' to continue check lecturer or 'n' to main lecturer menu. 


## Event

Created a eventHandler UI and event entity for event module, successfully implement comparableList.java, countableNumList.java and their interface for storing numerous events and events'attendees.

## Club

### Responsibilities 📝

#### 1. To manage a collection of clubs

```
- Registering a new club
- Deleting an existing club
- View the list of active clubs
```

#### 2. To manage students in a Club

```
- Adding a new student to a club
- Removing an existing student from a club
- Display all the students in a club
```

#### 3. To manage events of a Club

```
- Schedule a new event for a club
- Deleting a scheduled event for a club
- Display all the scheduled events of a club
```

### How-to's 📝

#### 1. To manage a collection of clubs

##### a. Registering a new club

![image](https://user-images.githubusercontent.com/59773847/112701422-91c45300-8ecb-11eb-9fdc-c4e4f732f916.png)

Simply enter `1` at this screen and you will be prompted to enter the club name

![image](https://user-images.githubusercontent.com/59773847/112701473-b3bdd580-8ecb-11eb-9313-18fe23ed9811.png)

Don't panic if you see this, this means the club is created and it will redirect you back to the previous screen.

##### b. View the list of active clubs

![image](https://user-images.githubusercontent.com/59773847/112701608-0b5c4100-8ecc-11eb-94d2-c96e2d49427f.png)

Enter `3` and you will see that the club is registered

![image](https://user-images.githubusercontent.com/59773847/112701631-20d16b00-8ecc-11eb-9261-135347ebd06f.png)

##### c. Removing an existing club

![image](https://user-images.githubusercontent.com/59773847/112701666-3b0b4900-8ecc-11eb-9f91-eb06f64295fe.png)

To remove an existing club, enter `2`and insert the club's id

![image](https://user-images.githubusercontent.com/59773847/112701802-8faec400-8ecc-11eb-86d0-0600a950e886.png)

After that, it will redirect you back to the previous screen.

#### 2. To manage students in a Club

![image](https://user-images.githubusercontent.com/59773847/112701941-f03e0100-8ecc-11eb-8013-e77b68cf1f55.png)

Firstly, enter `4` at this screen and enter the club's id

##### a. Adding a new student to a club

![image](https://user-images.githubusercontent.com/59773847/112701988-0f3c9300-8ecd-11eb-9aee-56f80af01187.png)

Enter `1` at this screen and you will be brought to the club members' management screen

![image](https://user-images.githubusercontent.com/59773847/112702039-33986f80-8ecd-11eb-8c28-721fd4e3b497.png)

Enter `1` again to add a new member to the club

![image](https://user-images.githubusercontent.com/59773847/112702101-5cb90000-8ecd-11eb-86f5-c6ba2c1f27f9.png)

Enter the student's details accordingly and he/she will be added to the club

##### b. Display all the students in a club

![image](https://user-images.githubusercontent.com/59773847/112702151-8114dc80-8ecd-11eb-898b-71ba8c647e58.png)

Enter `3` here to see all members in the club

![image](https://user-images.githubusercontent.com/59773847/112702320-0f895e00-8ece-11eb-9d0c-50c7b75ccb7c.png)

##### c. Removing an existing student from a club

![image](https://user-images.githubusercontent.com/59773847/112702338-1f08a700-8ece-11eb-9283-2011918fab7a.png)

Enter `2` and enter the student's id as following

![image](https://user-images.githubusercontent.com/59773847/112702369-38a9ee80-8ece-11eb-8190-0a7dbefa18db.png)

This shows that the student is successfully removed

#### 3. To manage events of a Club

![image](https://user-images.githubusercontent.com/59773847/112702459-8161a780-8ece-11eb-96a2-70ad790d8687.png)

First, enter `2` here to enter event's management screen

##### a. Schedule a new event for a club

![image](https://user-images.githubusercontent.com/59773847/112702484-950d0e00-8ece-11eb-95c0-9cc9b7adc689.png)

Enter `2` here and enter the required details as following

![image](https://user-images.githubusercontent.com/59773847/112702527-ca196080-8ece-11eb-9c7d-e64da3dd068e.png)

This shows that the new event is successfully created

##### b. Deleting a scheduled event for a club

![image](https://user-images.githubusercontent.com/59773847/112702570-e9b08900-8ece-11eb-92c7-3503740bee93.png)

Enter `3` and enter the sequence number of the event, in this case it's 1

![image](https://user-images.githubusercontent.com/59773847/112702599-05b42a80-8ecf-11eb-8349-14692df2872f.png)

This shows that the event is canceled and is redirecting you back to the previous screen

##### c. Display all the scheduled events of a club

![image](https://user-images.githubusercontent.com/59773847/112702665-3d22d700-8ecf-11eb-84ab-1874a106f64a.png)

Enter `1` and the list of registred events will be shown

### ADT (Abstract Data Type) 🧩

1. BinarySearchTree (BinarySearchTree.java, Tree.java)
2. LinkedListStack (IterableCustomStack.java)

A special use case here for **IterableCustomStack** here is that it is used for constructing an iterator of the traversal of BST (BinarySearchTree)

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

## Student Queue
### Responsibilities 📝
#### 1. Manage the student queuing for entering the event.
    - Check in Student enter the event
    - Display all student in the queue 
    - Display first check-in student
    - Display last check-in student
    - Remove the first student from the queue
    - Check the queue is empty
    - Shift the first student to the last position in the queue
    - Clear all the check-in student details

### ADT (Abstract Data Type)🧩
    - Flexible Queue(FlexibleQueueInterface.java, FlexibleQueue.java)

### Clients 💻
    -  StudentQueue.java

### How-to's 📝 

#### To enter the Student Queue, please choose “ 4 ”, then “ Enter ”

#### a. Check In Student 
1. Press '1' and click 'Enter'.
2. Key in the request information
3. Enter 'y/Y' to return the Student Queue main page  

#### b. Generate All Student
1. Press '2' and click 'Enter'.
2. System will display the details of the student with the current date and time. 
3. Enter 'y/Y' to return the Student Queue main page  

#### c. Find the first check-in Student
1. Press '3' and click 'Enter'.
2. System will display the details of the first student.
3. Enter 'y/Y' to return the Student Queue main page  

#### d. Find the last check-in Student
1. Press '4'' and click 'Enter'.
2. System will display the details of the last student.
3. Enter 'y/Y' to return the Student Queue main page  

#### e. Remove the Student
1. Press '5' and click 'Enter'.
2. Enter 'y/Y' to return the Student Queue main page  

#### f. Check Student Queue Empty
1. Press '6' and click 'Enter'.
2. Enter 'y/Y' to return the Student Queue main page  

#### g. Shift First Student to Last Position
1. Press '7' and click 'Enter'.
2. Enter 'y/Y' to return the Student Queue main page  

#### h. Clear All
1. Press '8' and click 'Enter'.
2. Enter 'y/Y' to return the Student Queue main page  



