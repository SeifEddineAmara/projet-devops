FROM openjdk:11
EXPOSE 8086
ADD http://192.168.33.10:8081/repository/Devops-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]