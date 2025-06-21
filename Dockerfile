# Multi-stage build for better performance
FROM maven:3.9.6-eclipse-temurin-21 as builder

# Set working directory
WORKDIR /app

# Copy pom.xml first for better layer caching
COPY pom.xml .

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src src

# Build the application
RUN mvn clean package -DskipTests

# Production stage
FROM eclipse-temurin:21-jre-jammy

# Install necessary packages
RUN apt-get update && apt-get install -y \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Create app user
RUN addgroup --system app && adduser --system --group app

# Set working directory
WORKDIR /app

# Copy the jar from builder stage
COPY --from=builder /app/target/AhorrArte-Platform-0.0.1-SNAPSHOT.jar app.jar

# Change ownership
RUN chown app:app app.jar

# Switch to app user
USER app

# Expose port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

# Set JVM options for container with preview features
ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 --enable-preview"

# Run the application
CMD ["sh", "-c", "java $JAVA_OPTS -Dserver.port=$PORT -Dspring.profiles.active=prod -Dlogging.level.root=INFO -Dlogging.level.org.springframework=DEBUG -jar app.jar"]
