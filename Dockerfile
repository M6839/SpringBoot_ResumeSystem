

FROM openjdk:21

# Copy the JAR file to the correct directory
COPY target/ResumeSystem_docker_app.jar /usr/app/

# Set the working directory
WORKDIR /usr/app
# Expose port
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "ResumeSystem_docker_app.jar"]
