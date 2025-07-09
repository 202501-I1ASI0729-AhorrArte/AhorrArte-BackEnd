#!/bin/sh

echo "Starting AhorrArte Backend..."
echo "Java Version:"
java -version

echo "Environment Variables:"
echo "SPRING_PROFILES_ACTIVE: $SPRING_PROFILES_ACTIVE"
echo "DATABASE_URL: $DATABASE_URL"
echo "MANUAL_DB_URL: $MANUAL_DB_URL"
echo "DB_USERNAME: $DB_USERNAME"
echo "JWT_SECRET: [HIDDEN]"
echo "JAVA_OPTS: $JAVA_OPTS"

echo "Starting application..."
exec java $JAVA_OPTS \
  -Dspring.profiles.active=prod \
  -Djava.security.egd=file:/dev/./urandom \
  -jar app.jar
