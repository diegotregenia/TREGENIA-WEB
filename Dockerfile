# Etapa de compilación
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Aquí debes poner el nombre correcto del .jar (no uses *.jar)
COPY --from=build /app/target/tregenia-web-0.0.1-SNAPSHOT.jar app.jar

# Puerto real de Spring Boot (Render ignora EXPOSE)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
