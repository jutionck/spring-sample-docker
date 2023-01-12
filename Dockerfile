FROM openjdk:17-jdk-alpine
ADD target/spring-sample-docker-0.0.1-SNAPSHOT.jar spring-sample-docker-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/spring-sample-docker-0.0.1-SNAPSHOT.jar"]