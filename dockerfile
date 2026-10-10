FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests -B


FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/curriVitae-0.0.1-SNAPSHOT.jar /app/curriVitae.jar

EXPOSE 9090

CMD ["java", "-jar", "/app/curriVitae.jar"]