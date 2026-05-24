FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app/Java/sprint-integracao-quarkus
COPY . .
RUN mvn -B -DskipTests clean package
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/Java/sprint-integracao-quarkus/target/quarkus-app/ ./quarkus-app/
EXPOSE 8080
CMD ["java", "-jar", "quarkus-app/quarkus-run.jar"]