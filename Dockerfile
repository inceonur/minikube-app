FROM openjdk:17
VOLUME /tmp
COPY target/minikube-app-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /app.jar --debug

