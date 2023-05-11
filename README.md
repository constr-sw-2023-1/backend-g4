# Resources API (G4)

### :warning: Requirements
* Java 17
* Docker
* Gradle

### :cloud: Cloud Endpoints
The following URLs are hosted on OCI, the following links can redirect you to it.
- [Resources API]().
- [MongoDB]().

### :whale2: Docker Image
- The docker [Resources image]() can be pulled from the GHCR.

### :open_book: API Docs
You can acess [Swagger]() to check the API docs.

## :hammer_and_wrench: Building the project
Use the following command to build the project:
```
./gradlew build
```

## :runner: Running the Project
Use the following command to run the project:
```
java -jar build/libs/resources-0.1.0.jar
```

## :running_woman: Running the Project with Docker Compose
Use the following commands to run the project with Docker:
```
make build
make up
```
