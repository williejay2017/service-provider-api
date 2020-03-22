FROM openjdk:11-jre-slim
RUN ./gradlew build
ADD build/libs/service-provider-api.jar service-provider-api.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "service-provider-api.jar"]
