FROM openjdk:8-jdk-alpine

LABEL maintainer="vamsi-p@gmail.com"

VOLUME /tmp

EXPOSE 3000

ARG JAR_FILE=target/springboot-test-1.0.0.jar

ADD ${JAR_FILE} websocket-demo.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/websocket-demo.jar"]
