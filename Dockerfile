FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/docker-spring-boot-tp-achat.jar docker-spring-boot-tp-achat.jar
ENTRYPOINT ["java","-jar","/docker-spring-boot-tp-achat.jar"]