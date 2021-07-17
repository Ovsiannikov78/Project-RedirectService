#
# Build stage
#
FROM maven:3.6.3-jdk-11 AS build
#FROM maven:3.6.3-jdk-8
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true
#RUN mvn -f /home/app/pom.xml clean package      =============>>>>> with tests



#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /home/app/target/redirect-service-0.0.1-SNAPSHOT.jar /usr/local/lib/RedirectService.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/usr/local/lib/RedirectService.jar"]
