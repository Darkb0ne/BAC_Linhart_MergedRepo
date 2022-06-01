FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
MAINTAINER darkb0ne
ENV PORT 8761
EXPOSE 8761
COPY target/blog-eureka.jar blog-eureka.jar
ENTRYPOINT ["java","-jar","/blog-eureka.jar"]