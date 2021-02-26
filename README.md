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
```

⚠ Use `gradlew.bat` if you're on Windows.

## Builid Configuration

The entry point of the project should be defined in `build.gradle`. Gradle will not run properly if the entry point is not defined.

```gradle
...
mainClassName = 'UCHelper.client.Main'
...
```