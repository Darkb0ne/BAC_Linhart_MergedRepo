FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
MAINTAINER darkb0ne
ENV PORT 9090
EXPOSE 9090
COPY target/blog-gateway.jar blog-gateway.jar
ENTRYPOINT ["java","-jar","/blog-gateway.jar"]