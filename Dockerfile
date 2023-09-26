FROM openjdk:17
VOLUME /tmp
EXPOSE 9090
ARG JAR_FILE=target/minikube-app-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} minikube-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/minikube-app-0.0.1-SNAPSHOT.jar"]