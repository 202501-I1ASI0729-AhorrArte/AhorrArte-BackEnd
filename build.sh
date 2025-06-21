#!/bin/bash

# Build script for Render deployment
echo "Starting build process..."

# Make sure we have the right permissions
chmod +x ./mvnw

# Clean and build the project
echo "Building the application..."
./mvnw clean package -DskipTests -q

echo "Build completed successfully!"

# Verify the JAR file was created
if [ -f "target/AhorrArte-Platform-0.0.1-SNAPSHOT.jar" ]; then
    echo "JAR file created successfully"
    ls -la target/*.jar
else
    echo "ERROR: JAR file not found!"
    exit 1
fi
