FROM openjdk:21
COPY "./target/saberpro-0.0.1-SNAPSHOT.jar" "saberpro.jar"
EXPOSE 8043
ENTRYPOINT ["java", "-jar", "saberpro.jar"]