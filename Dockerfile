FROM openjdk:17

ARG JAR_FILE=target/*.jar

WORKDIR /app

COPY ${JAR_FILE} api.jar

ENTRYPOINT ["java", "-jar", "/app/api.jar"]

EXPOSE 8080
