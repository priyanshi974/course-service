FROM openjdk:17-alpine
EXPOSE 8088
ADD target/course-service.jar course-service.jar
ENTRYPOINT ["java", "-jar", "/course-service.jar"]