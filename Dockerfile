FROM openjdk:8
EXPOSE 8086
ADD target/DevOps_Project-2.1.jar DevOps_Project-2.1.jar
ENTRYPOINT ["java", "-jar", "/DevOps_Project-2.1.jar"]