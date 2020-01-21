FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ADD target/poc2-customer-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
CMD ["echo", "customer api is up & running..."]