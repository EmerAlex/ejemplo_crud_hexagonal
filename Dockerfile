# java image to use
FROM openjdk
# Copy jar from target dir to docker image
EXPOSE 8083
ADD build/libs/*.jar app.jar
# Run app
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ] 