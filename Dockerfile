FROM openjdk:18
WORKDIR /app
COPY . /app/
RUN javac MinikubeAppApplication.java
ENTRYPOINT [ "java", "MinikubeAppApplication" ]
