# Use a base image of Java 17
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the generated JAR file from the project's target directory to the working directory
COPY target/Backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the Spring Boot application runs (adjust the port number according to your configuration)
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
ENTRYPOINT ["sh", "-c", "sleep 30 && java -jar app.jar"]

