FROM openjdk:11
EXPOSE 8089
ADD target/DevOps_Project-2.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

