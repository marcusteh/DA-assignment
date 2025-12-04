#!/bin/bash

echo "Implement me!"
set -e

echo "Shutting down any old containers..."
docker compose down --volumes --remove-orphans || true

echo "Building application using Gradle..."
./gradlew clean build -x test

echo "Starting MySQL and Spring Boot containers..."
docker compose up --build -d

echo "Waiting for services to start..."
until curl -s http://localhost:8080/actuator/health | grep '"status":"UP"' > /dev/null; do
  echo " → Waiting for Spring Boot to be UP..."
  sleep 3
done

echo "API is available at http://localhost:8080"