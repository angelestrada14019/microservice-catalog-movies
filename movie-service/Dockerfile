FROM maven:3-jdk-8-alpine as builder

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn package

FROM openjdk:8-jre-alpine

COPY --from=builder /usr/src/app/target/*.jar /movie-service.jar

EXPOSE 8084

ENTRYPOINT ["java"]
CMD ["-jar", "/movie-service.jar"]