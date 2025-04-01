FROM openjdk:17-jdk-slim as builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/employeemanagement-0.0.1-SNAPSHOT.jar /app/employeemanagement.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/employeemanagement.jar"]
