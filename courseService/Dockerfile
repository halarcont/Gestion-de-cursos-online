FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/courseService-*.jar courseService.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker", "courseService.jar"]