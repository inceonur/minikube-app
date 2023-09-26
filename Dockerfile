# Docker Build Stage
FROM maven:3-jdk-8-alpine AS build


# Build Stage
WORKDIR /app

COPY . /app/

RUN mvn clean install -DskipTests


# Docker Build Stage
FROM openjdk:17

COPY target/minikube-app-0.0.1-SNAPSHOT.jar app.jar

ENV PORT 9090
EXPOSE $PORT

ENTRYPOINT ["java","-jar","/app.jar"]
