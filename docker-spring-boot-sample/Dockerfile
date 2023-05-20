# Start with a base image containing Java runtime
FROM openjdk:11-slim as build 

# Information about the maintainer of the image
MAINTAINER ksdhandapani96@gmail.com

# Add the application's jar to the container
COPY target/docker-spring-boot-sample-0.0.1-SNAPSHOT.jar docker-spring-boot-sample-0.0.1-SNAPSHOT

# Execute the application
ENTRYPOINT ["java","-jar","/docker-spring-boot-sample-0.0.1-SNAPSHOT"]