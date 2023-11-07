FROM openjdk:11
EXPOSE 8089
ADD http://192.168.1.13:8081/repository/devops-releases/tn/esprit/DevOps_Project/2.1/DevOps_Project-2.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]