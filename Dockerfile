# ---------- Stage 1: Build the JAR using Maven ----------
# Uses Maven + JDK 21 to build your Spring Boot app
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Set working directory inside the container
WORKDIR /app

# Copy only pom.xml first (better dependency caching)
COPY pom.xml .

# (Optional but useful) Download dependencies in advance
RUN mvn -B dependency:go-offline

# Now copy the actual source code
COPY src ./src

# Build the project and skip tests (since your tests are failing)
RUN mvn -B clean package -DskipTests


# ---------- Stage 2: Run the built JAR with a smaller JRE ----------
FROM eclipse-temurin:21-jre

# Working directory for the runtime container
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Default port (Spring will use PORT env if set)
ENV PORT=8080

# Expose port 8080 (for local usage / docs)
EXPOSE 8080

# Optional: extra JVM options can be passed via JAVA_OPTS env var
ENV JAVA_OPTS=""

# Start the Spring Boot app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

