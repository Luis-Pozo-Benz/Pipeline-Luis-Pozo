# Usa JDK 21
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copia pom y código
COPY pom.xml .
COPY src ./src

# Build con Maven
RUN ./mvnw package -DskipTests

# Expone puerto 8080
EXPOSE 8080

# Ejecuta el JAR generado
CMD ["java", "-jar", "target/pipeline-0.0.1-SNAPSHOT.jar"]
