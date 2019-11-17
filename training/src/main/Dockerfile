FROM openjdk:8-jre-alpine
RUN echo "Asia/Shanghai" > /etc/timezone
COPY training.jar /app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -server -Xms128m -Xmx256m -Duser.timezone=GMT+08 -jar /app.jar " ]
