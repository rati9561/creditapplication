FROM openjdk:17
EXPOSE 8181
ADD target/creditapplication.jar creditapplication.jar
ENTRYPOINT ["java","-jar","/creditapplication.jar"]
