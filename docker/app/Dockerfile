FROM gradle:jdk17 as builder
WORKDIR /test-kotlin-app
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN --mount=type=cache,target=./.gradle gradle clean test install

FROM openjdk:17-alpine as backend
WORKDIR /root
COPY --from=builder /app/build/install/app ./