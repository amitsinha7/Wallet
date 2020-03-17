FROM openjdk:11-slim
WORKDIR /app
COPY target/wallet-api*.jar wallet-api.jar
ENTRYPOINT ["java","-jar","/app/wallet-api.jar"]
