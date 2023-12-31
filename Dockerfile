FROM openjdk:17-jdk-alpine as builder

EXPOSE 8080

RUN apk add --update git  \
    && git clone https://github.com/KseniaLune/TestTask.git

WORKDIR TestTask

ENTRYPOINT ["./gradlew", "bootRun"]
