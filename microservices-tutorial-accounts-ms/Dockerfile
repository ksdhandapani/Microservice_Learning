# Start with a base image containing Java runtime
FROM openjdk:11-slim as build 

# Information around who maintains the image
MAINTAINER ksdhandapani96@gmail.com

# Add the application's jar to the container
COPY target/microservices-tutorial-accounts-ms-0.0.1-SNAPSHOT.jar microservices-tutorial-accounts-ms-0.0.1-SNAPSHOT

# Execute the application
ENTRYPOINT ["java","-jar","/microservices-tutorial-accounts-ms-0.0.1-SNAPSHOT"]
