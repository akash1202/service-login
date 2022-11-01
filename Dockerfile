From openjdk:17
CMD ["gradlew","clean"]
CMD ["gradlew","build"]
WORKDIR /app
COPY build/libs/*.jar app.jar
# ARG JAR_FILE="build/libs/service-login-0.0.1-SNAPSHOT.jar"
# COPY ${JAR_FILE} /app/app.jar
 ENTRYPOINT [ "java","-jar","app.jar" ]