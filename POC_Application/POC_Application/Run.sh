#!/bin/sh

# Pull the latest images
docker pull DOCKER_USERNAME/angular_test_1
docker pull DOCKER_USERNAME/springboot_test_1

# Remove existing containers if any
docker rm -f angular_test_1 || true
docker rm -f springboot_test_1 || true

# Run the Docker containers
docker run -d -p 8081:8081 --name angular_test_1 DOCKER_USERNAME/angular_test_1
docker run -d -p 8080:8080 --name springboot_test_1 DOCKER_USERNAME/springboot_test_1
