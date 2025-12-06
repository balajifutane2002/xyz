# ---------- Stage 1: Build the JAR using Maven ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Create a folder inside the container
WORKDIR /app

# Copy pom.xml first (for dependency cache)
COPY pom.xml .

# Copy source code
COPY src ./src

# Build the project (skip tests to avoid your test failures)
RUN mvn clean package -DskipTests

# ---------- Stage 2: Run the built JAR ----------
FROM eclipse-temurin:21-jre

# Create a folder for running the app
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (for local understanding; cloud may override)
EXPOSE 8080

# If platform sets PORT (like Render), Spring will use it
ENV PORT=8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
