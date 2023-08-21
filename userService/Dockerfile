FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/userService-*.jar userService.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker", "userService.jar"]