FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} productservice.jar

ENTRYPOINT ["java", "-jar", "/api.jar"]

EXPOSE 8080