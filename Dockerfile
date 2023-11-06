FROM openjdk:8
EXPOSE 8086
ADD target/DevOps_Project-2.1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]