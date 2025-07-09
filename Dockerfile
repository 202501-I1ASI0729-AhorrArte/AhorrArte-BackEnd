# Use Maven image for build stage
FROM maven:3.9.5-openjdk-23-slim AS build

# Set working directory
WORKDIR /app

# Copy pom.xml first for better layer caching
COPY pom.xml .

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests -B

# Use OpenJDK for runtime
FROM openjdk:23-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar from build stage
COPY --from=build /app/target/AhorrArte-Platform-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will assign a port, but this is for documentation)
EXPOSE 8080

# Set default Java options (can be overridden by environment variable)
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Run the application with Java options
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
