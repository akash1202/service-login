FROM gradle:7.5.1-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon
FROM neowu/jre:17.0.4
EXPOSE 8083
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/service-login.jar
# COPY build/libs/*.jar app.jar
# ARG JAR_FILE="build/libs/service-login-0.0.1-SNAPSHOT.jar"
# COPY ${JAR_FILE} /app/app.jar
 ENTRYPOINT [ "java","-jar","/app/service-login.jar" ]
