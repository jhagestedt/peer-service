#!/usr/bin/env bash
mvn clean package
java -jar -Dspring.profiles.active=azure-consul app/target/peer-service-app-0.0.1-SNAPSHOT.jar