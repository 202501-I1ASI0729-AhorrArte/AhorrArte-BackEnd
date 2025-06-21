#!/bin/bash

# Start script for Render deployment
echo "Starting AhorrArte Platform..."

# Set default values if environment variables are not set
export SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE:-prod}
export PORT=${PORT:-8080}

# Log environment information
echo "Profile: $SPRING_PROFILES_ACTIVE"
echo "Port: $PORT"
echo "Java Version: $(java -version 2>&1 | head -n 1)"

# Start the application
exec java $JAVA_OPTS \
    -Dserver.port=$PORT \
    -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE \
    -jar target/AhorrArte-Platform-0.0.1-SNAPSHOT.jar
