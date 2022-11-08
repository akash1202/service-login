FROM gradle:7.5.1-jdk17-alpine
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle build --no-daemon 
COPY --from=build build/libs/*.jar app.jar
# COPY build/libs/*.jar app.jar
# ARG JAR_FILE="build/libs/service-login-0.0.1-SNAPSHOT.jar"
# COPY ${JAR_FILE} /app/app.jar
 ENTRYPOINT [ "java","-jar","app.jar" ]
