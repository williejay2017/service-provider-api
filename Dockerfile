FROM openjdk:11-jre-slim
ADD build/libs/service-provider-api.jar .
EXPOSE 8888
CMD java -jar service-provider-api.jar
