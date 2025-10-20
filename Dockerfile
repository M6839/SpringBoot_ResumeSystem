# ----------------------
# Stage 1: Build JAR
# ----------------------
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (cached layer)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the Spring Boot JAR (skip tests for faster build)
RUN mvn clean package -DskipTests

# ----------------------
# Stage 2: Run app
# ----------------------
FROM eclipse-temurin:17

# Set working directory
WORKDIR /usr/app

# Copy the JAR built from Stage 1
COPY --from=build /app/target/*.jar ./app.jar

# Expose the port your app runs on
EXPOSE 9090

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
