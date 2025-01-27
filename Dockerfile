# Base image
FROM eclipse-temurin:17-jdk AS build

# Set working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Package application
RUN ./mvnw package -DskipTests

# Run the application
CMD ["java", "-jar", "target/todolist-0.0.1-SNAPSHOT.jar"]
