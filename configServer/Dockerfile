FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/configServer-*.jar configServer.jar
ENTRYPOINT ["java","-jar","configServer.jar"]