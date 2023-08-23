#!/bin/bash
# Change to the directory containing the Docker Compose file
cd /home/chetansingh/Working_Directory/POC_Application
# Start the containers using Docker Compose
docker-compose up
# Check if the containers are running
if [ "$(docker ps -q -f name=springboot_mysql_net)" ]; then
    echo "Containers started successfully!"
else
    echo "Failed to start containers."
fi
