FROM openjdk:11
EXPOSE 8082
ADD DevOps_Project-2.1.jar devops-project.jar
ENTRYPOINT ["java","-jar","devops-project.jar"]