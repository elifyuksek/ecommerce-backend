# 1. Aşama: Build
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew bootJar -x test

# 2. Aşama: Run
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]