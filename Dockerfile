FROM openjdk:17

COPY target/minikube-app-0.0.1-SNAPSHOT.jar app.jar

ENV PORT 9090
EXPOSE $PORT

WORKDIR /app

COPY . /app/

RUN exec java -jar /app.jar

ENTRYPOINT [ "java", "Main" ]