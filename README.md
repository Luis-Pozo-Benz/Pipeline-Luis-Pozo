# Pipeline CI/CD - Luis Pozo

# Descripción del proyecto
Aplicación headless REST API desarrollada para la práctica de CI/CD Pipeline que gestiona:

Personas con su talla de pie

Zapatos con marca y precio

Relación many-to-many entre personas y zapatos

## Estructura del proyecto
```text
│   docker-compose.yml
│   README.md
│
├───.github
│   └───workflows
│           ci.yml
│
├───.vscode
│       settings.json
│
└───Pipeline
    │   .gitattributes
    │   .gitignore
    │   checkstyle.xml
    │   dockerfile
    │   HELP.md
    │   mvnw
    │   mvnw.cmd
    │   pom.xml
    │
    ├───.mvn
    │   └───wrapper
    │           maven-wrapper.properties
    │
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───eu
    │   │   │       └───cifpfbmoll
    │   │   │           └───Pipeline
    │   │   │               │   PipelineApplication.java
    │   │   │               │
    │   │   │               ├───controller
    │   │   │               │       PersonaController.java
    │   │   │               │       ZapatoController.java
    │   │   │               │
    │   │   │               ├───model
    │   │   │               │       Persona.java
    │   │   │               │       Zapato.java
    │   │   │               │
    │   │   │               ├───repository
    │   │   │               │       PersonaRepository.java
    │   │   │               │       ZapatoRepository.java
    │   │   │               │
    │   │   │               └───service
    │   │   │                       PersonaService.java
    │   │   │                       ZapatoService.java
    │   │   │
    │   │   └───resources
    │   │       │   application.properties
    │   │       │   data.sql
    │   │       │
    │   │       ├───static
    │   │       └───templates
    │   └───test
    │       ├───java
    │       │   └───eu
    │       │       └───cifpfbmoll
    │       │           └───Pipeline
    │       │               │   PipelineApplicationTests.java
    │       │               │
    │       │               ├───controller
    │       │               │       PersonaControllerTest.java
    │       │               │       ZapatoControllerTest.java
    │       │               │
    │       │               ├───repository
    │       │               │       PersonaRepositoryTest.java
    │       │               │       ZapatoRepositoryTest.java
    │       │               │
    │       │               └───service
    │       │                       PersonaServiceTest.java
    │       │                       ZapatoServiceTest.java
    │       │
    │       └───resources
    │               application-test.properties
    │
    └───target
            checkstyle-cachefile
            checkstyle-checker.xml
            checkstyle-result.xml

```
## Tecnologías
```bash
    - Spring Boot 4.0.2
    - JDK 21 Temurin
    - Hibernate JPA
    - PostgreSQL 15
    - Maven
    - JUnit 5
    - AssertJ
    - Docker Compose
    - GitHub Actions
```
## Instalación y ejecución local
1. Build y tests
```bash
cd Pipeline
mvn clean validate test        # Tests + Checkstyle
mvn clean package -DskipTests  # Solo build JAR
```
3. Entorno desarrollo Docker
```bash
docker compose up --build
```

4. Verificar API
```bash
# Base de datos (fixtures cargados)
docker exec -it pipeline_db psql -U postgres -d pipeline -c "SELECT * FROM personas;"
```

## Pipeline CI/CD Automática 
Se ejecuta en cada push/PR a main:
```text
1. Checkstyle (linting código)
2. 9 JUnit tests (H2 in-memory)
3. Maven package (JAR)
4.  Docker build (Postgres + App)
5. Tests aceptación (curl endpoints)
```
Ver ejecuciones: GitHub Actions
