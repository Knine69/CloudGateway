FROM amazoncorretto:17.0.8-alpine3.15
WORKDIR /app
COPY build/libs/CloudGateway-1.0-SNAPSHOT.jar /app/gateway-app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "gateway-app.jar"]
