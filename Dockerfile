FROM maven:3.8.3-openjdk-17

COPY . /usr/src/app

WORKDIR /usr/src/app

RUN mvn clean install

FROM openjdk:17-jdk-alpine

COPY --from=0 /usr/src/app/target/orangeblood-0.0.1-SNAPSHOT.jar /apps/app.jar

ENTRYPOINT ["java", "-jar", "/apps/app.jar"]

