# Use Maven image for build stage (using Eclipse Temurin)
FROM maven:3.9-eclipse-temurin-21 AS build

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

# Use Eclipse Temurin for runtime (recommended replacement for OpenJDK)
FROM eclipse-temurin:21-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built jar from build stage
COPY --from=build /app/target/AhorrArte-Platform-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Set Java options
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseG1GC -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Run the application
CMD java $JAVA_OPTS -Dspring.profiles.active=prod -jar app.jar
