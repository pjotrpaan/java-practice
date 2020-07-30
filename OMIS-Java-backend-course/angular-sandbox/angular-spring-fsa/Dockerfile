FROM openjdk:13
WORKDIR '/webapp'
ARG ARTIFACT_NAME=angular-spring-fsa-1.0-SNAPSHOT.jar
ARG ARTIFACT_PATH_NAME=target/${ARTIFACT_NAME}
COPY $ARTIFACT_PATH_NAME .
EXPOSE 8080
ENV SERVER_PORT=8080
ENTRYPOINT ["java","-jar","angular-spring-fsa-1.0-SNAPSHOT.jar", "ee.paan.Application"]