FROM openjdk:17
WORKDIR /app
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /app/account-service.jar
EXPOSE 8081

ENTRYPOINT ["java","-jar","account-service.jar"]
