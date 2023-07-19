FROM openjdk:17-jdk-alpine
ADD target/eurekaServer-*.jar eureka.jar
ENTRYPOINT ["java","-jar","eureka.jar"]