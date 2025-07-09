#!/bin/sh

echo "=== AhorrArte Backend Starting ==="
echo "Java Version:"
java -version

echo ""
echo "Environment Variables:"
echo "SPRING_PROFILES_ACTIVE: $SPRING_PROFILES_ACTIVE"
echo "DATABASE_URL: ${DATABASE_URL:0:50}..." # Only show first 50 chars for security
echo "MANUAL_DB_URL: $MANUAL_DB_URL"
echo "DB_USERNAME: $DB_USERNAME"
echo "DB_PASSWORD: [${#DB_PASSWORD} characters]"
echo "JWT_SECRET: [${#JWT_SECRET} characters]"
echo "JAVA_OPTS: $JAVA_OPTS"
echo "PORT: $PORT"

echo ""
echo "Testing database connectivity..."
echo "Database URL format check:"
if [ -n "$MANUAL_DB_URL" ]; then
    echo "Using MANUAL_DB_URL: ${MANUAL_DB_URL:0:50}..."
else
    echo "Using DATABASE_URL: ${DATABASE_URL:0:50}..."
fi

echo ""
echo "=== Starting Spring Boot Application ==="
echo "Command that will be executed:"
echo "java $JAVA_OPTS -Dspring.profiles.active=prod -Djava.security.egd=file:/dev/./urandom -Dlogging.level.org.springframework.boot.diagnostics=DEBUG -jar app.jar"

set -e  # Exit on any error

java $JAVA_OPTS \
  -Dspring.profiles.active=prod \
  -Djava.security.egd=file:/dev/./urandom \
  -Dlogging.level.org.springframework.boot.diagnostics=DEBUG \
  -Dspring.main.banner-mode=console \
  -jar app.jar
