#base image: linux alpine os with open jdk 8
FROM maven:3.9.8-eclipse-temurin-8 AS build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean package

FROM eclipse-temurin:8-alpine

#copy jar from local into docker image
COPY --from=build /app/target/accountservice-0.0.1-SNAPSHOT.jar accountservice-0.0.1-SNAPSHOT.jar

# Expose port
EXPOSE 8080
#command line to run jar
ENTRYPOINT ["java","-jar","/accountservice-0.0.1-SNAPSHOT.jar"]
