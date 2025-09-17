FROM eclipse-temurin:17-jre-alpine
EXPOSE 8181
ADD target/creditapplication.jar creditapplication.jar
ENTRYPOINT ["java","-jar","/creditapplication.jar"]
