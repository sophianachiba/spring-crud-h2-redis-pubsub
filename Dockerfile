FROM openjdk:8-jdk-alpine
MAINTAINER sophian Achiba
COPY target/spring-boot-jpa-h2-0.0.1-SNAPSHOT.jar spring-boot-jpa-h2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-jpa-h2-0.0.1-SNAPSHOT.jar"] 