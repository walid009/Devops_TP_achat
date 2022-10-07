FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/docker-spring-boot-tpAchat-branch-walid.war docker-spring-boot-tpAchat-branch-walid.war
ENTRYPOINT ["java","-jar","/docker-spring-boot.war"]
