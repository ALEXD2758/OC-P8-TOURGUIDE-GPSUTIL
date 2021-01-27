FROM openjdk:8-alpine
WORKDIR /usr/app
COPY build/libs/gps-1.0.0.jar tourguide-gps.jar
CMD ["java", "-jar", "tourguide-gps.jar"]