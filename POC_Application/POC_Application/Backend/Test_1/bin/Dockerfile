FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
WORKDIR /usr/src/app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/app.jar"]