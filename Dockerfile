FROM gradle:jdk17 as builder
WORKDIR /test-kotlin-app
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN gradle clean build

FROM openjdk:17-alpine as backend
WORKDIR /root
COPY --from=builder /test-kotlin-app/build/libs/* ./app
ENTRYPOINT ["java", "-jar", "/root/app"]