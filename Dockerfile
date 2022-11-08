FROM gradle:7.5.1-jdk17-alpine
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 
From openjdk:17
WORKDIR /app
COPY build/libs/*.jar app.jar
# ARG JAR_FILE="build/libs/service-login-0.0.1-SNAPSHOT.jar"
# COPY ${JAR_FILE} /app/app.jar
 ENTRYPOINT [ "java","-jar","app.jar" ]
