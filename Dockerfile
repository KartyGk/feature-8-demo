FROM openjdk:8
EXPOSE 8180
ADD target/jenkins-docker-integration.jar jenkins-docker-integration.jar
ENTRYPOINT ["java","-jar","/jenkins-docker-integration.jar"]