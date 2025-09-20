# 1. Base image with Java
FROM openjdk:21-jdk-slim

# 2. Set a folder inside container
WORKDIR /app

# 3. Copy your JAR into container
COPY target/myApp.jar .

# 4. Expose port 8080
EXPOSE 8080

# 5. Command to run your app
ENTRYPOINT ["java","-jar","myApp.jar"]