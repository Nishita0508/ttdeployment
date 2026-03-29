FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# copy backend project
COPY career-guidance-system /app

# build project
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# run spring boot jar (correct path)
CMD sh -c "java -jar target/*.jar"