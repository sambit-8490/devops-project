# Build stage: Maven to build the app
FROM maven AS build

WORKDIR /app

# Copy the project files
COPY . .

# Build the project using Maven
RUN mvn clean install -DskipTests


# Run stage: OpenJDK to run the app
FROM openjdk:17-jdk-slim

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar ./employee.jar

# Optionally, add a health check (for Spring Boot app, you can change the health URL accordingly)
# HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1

# Set the entry point to run the Java application
CMD ["java", "-jar", "employee.jar"]
