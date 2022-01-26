FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} exchange.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "exchange.jar"]
