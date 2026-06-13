# syntax=docker/dockerfile:1
FROM eclipse-temurin:21-jdk AS build
WORKDIR /build
COPY pom.xml .
COPY swap-rules-core/pom.xml swap-rules-core/
COPY swap-rules-runtime/pom.xml swap-rules-runtime/
COPY swap-rules-store/pom.xml swap-rules-store/
COPY swap-rules-admin/pom.xml swap-rules-admin/
COPY swap-rules-shadow/pom.xml swap-rules-shadow/
COPY swap-rules-archtest/pom.xml swap-rules-archtest/
COPY swap-rules-jmh/pom.xml swap-rules-jmh/
COPY swap-rules-loadtest/pom.xml swap-rules-loadtest/
COPY trade-capture-service/pom.xml trade-capture-service/
COPY swap-archiver/pom.xml swap-archiver/
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*
COPY . .
RUN mvn -B -pl swap-rules-admin -am package -DskipTests

FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /app
COPY --from=build /build/swap-rules-admin/target/swap-rules-admin-*.jar app.jar
USER nonroot
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
