FROM openjdk:17
LABEL maintainer ="minikube-app"
ADD target/minikube-app-0.0.1-SNAPSHOT.jar minikube-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","minikube-app-0.0.1-SNAPSHOT.jar"]