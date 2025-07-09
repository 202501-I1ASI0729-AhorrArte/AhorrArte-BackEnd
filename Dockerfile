# Use Eclipse Temurin JDK 17 as base image
FROM eclipse-temurin:17-jdk-alpine AS build

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Make mvnw executable
RUN chmod +x ./mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Runtime stage - Java 21 for preview features
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Install curl for health checks
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Copy the jar from build stage
COPY --from=build /app/target/AhorrArte-Platform-0.0.1-SNAPSHOT.jar app.jar

# Create non-root user
RUN addgroup --system spring && adduser --system --group spring

# Change ownership of the app directory
RUN chown -R spring:spring /app
USER spring:spring

# Expose port
EXPOSE 8080

# Health check - use dynamic port
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:${PORT:-8080}/actuator/health || exit 1

# Run the application with production profile and preview features
ENTRYPOINT ["sh", "-c", "java --enable-preview -Dserver.port=${PORT:-8080} -Dspring.profiles.active=prod -jar app.jar"]
