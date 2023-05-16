# Resources API (G4)

### :warning: Requirements
* Java 17
* Docker
* Gradle

### :cloud: Cloud Endpoints
The following URLs are hosted on OCI, the following links can redirect you to it.
- [Resources API](http://168.75.107.143:8084/swagger-ui/index.html#/).
- [MongoDB](http://168.75.107.143:27017/).

### :whale2: Docker Image
- The docker [Resources image](https://github.com/constr-sw-2023-1/backend-g4/pkgs/container/backend-g4) can be pulled from the GHCR.

### :open_book: API Docs
You can acess [Swagger](http://localhost:8084/swagger-ui/index.html#/) to check the API docs.

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
