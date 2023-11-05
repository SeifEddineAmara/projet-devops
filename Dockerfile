FROM openjdk:11
EXPOSE 8089
ADD target/DevOps_Project-2.1.jar devops-integration.jar
ENTRYPOINT ["java","-jar","/devops-integration.jar"]
