FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/eurekaServer-*.jar eureka.jar
ENTRYPOINT ["java","-jar","eureka.jar"]