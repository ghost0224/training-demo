FROM openjdk:8-jre-alpine
RUN echo "Asia/Shanghai" > /etc/timezone
COPY zuul-server.jar /app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -server -Xms256m -Xmx1024m -Duser.timezone=GMT+08 -jar /app.jar " ]
