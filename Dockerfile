FROM gradle:jdk17 as builder
WORKDIR /test-kotlin-app
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN gradle clean build

FROM openjdk:17-alpine as backend
WORKDIR /root
COPY --from=builder /test-kotlin-app/build/libs/* ./app
ENTRYPOINT ["java", "-jar", "-Dspring.datasource.url=jdbc:postgresql://172.21.1.2:5432/kotlin-app", "/root/app"]