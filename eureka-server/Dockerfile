FROM openjdk:latest
ADD target/eureka-server-1.0-SNAPSHOT.jar eureka-server-1.0-SNAPSHOT.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/eureka-server-1.0-SNAPSHOT.jar"]
