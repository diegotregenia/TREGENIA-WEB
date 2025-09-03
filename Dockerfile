# Usa una imagen oficial de Maven para construir el proyecto
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Crea directorio de trabajo
WORKDIR /app

# Copia los archivos al contenedor
COPY . .

# Construye el proyecto usando Maven
RUN mvn clean package -DskipTests

# Usa una imagen JDK para ejecutar el JAR
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia el JAR desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto 8080
EXPOSE 10000

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
