FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 8761
ADD target/eurekaServer-0.0.1-SNAPSHOT.jar eureka.jar
RUN apk --no-cache add curl
ENTRYPOINT ["java","-jar","/eureka.jar"]