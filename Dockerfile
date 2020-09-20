from openjdk:8-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} demo-docker.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod", "-jar","/demo-docker.jar"]
