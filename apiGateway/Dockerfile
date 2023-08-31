FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/apiGateway-*.jar apiGateway.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker", "apiGateway.jar"]