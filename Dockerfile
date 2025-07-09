# Use OpenJDK 23 as base image
FROM openjdk:23-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first for better layer caching
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY pom.xml .

# Make Maven wrapper executable
RUN chmod +x ./mvnw

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (Render will assign a port, but this is for documentation)
EXPOSE 8080

# Set default Java options (can be overridden by environment variable)
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Run the application with Java options
CMD ["sh", "-c", "java $JAVA_OPTS -jar target/AhorrArte-Platform-0.0.1-SNAPSHOT.jar"]
