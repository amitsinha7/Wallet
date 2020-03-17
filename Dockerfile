FROM java:8-jdk-alpine
COPY ./target/wallet-api-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch wallet-api-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","wallet-api-0.0.1-SNAPSHOT.jar"]