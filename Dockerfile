# Stage 1: Build JAR
FROM maven:3.9.2-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21
WORKDIR /usr/app
COPY --from=build /app/target/*.jar ./app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
