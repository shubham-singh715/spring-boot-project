FROM openjdk:11
ADD target/spring-boot-assignment.jar spring-boot-assignment.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-boot-assignment.jar"]