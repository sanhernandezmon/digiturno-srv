FROM openjdk:11
ADD build/libs/digiturno-srv-0.0.1-SNAPSHOT.jar /digiturno-srv/digiturno-srv-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar",  "digiturno-srv/digiturno-srv-0.0.1-SNAPSHOT.jar"]
