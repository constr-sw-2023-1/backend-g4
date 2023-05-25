# Resources API (G4)

### :warning: Requirements
* Java 17
* Docker
* Gradle

### :cloud: Cloud Endpoints
The following URLs are hosted on OCI, the following links can redirect you to it.
- [Resources API](http://168.75.107.143:8084/).
- [MongoDB](http://168.75.107.143:27017/).
- [OAuth API](http://168.75.107.143:8080/).
- [Keycloak Admin](http://168.75.107.143:8090/).

### :whale2: Docker Image
- The docker [Resources image](https://github.com/constr-sw-2023-1/backend-g4/pkgs/container/backend-g4) can be pulled from the GHCR.

### :open_book: API Docs
- You can acess [Swagger](http://168.75.107.143:8084/swagger-ui/index.html#/) to check the API docs.

### 🏥 API Health
- You can acess [Health Monitor](http://168.75.107.143:8084/actuator/health/) to check the API health.

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

## 🥬MongoDB Diagram
<img width="460" alt="image" src="https://github.com/constr-sw-2023-1/backend-g4/assets/83477377/f40e68a7-c9a2-4c87-bbf1-571120636ca0">


