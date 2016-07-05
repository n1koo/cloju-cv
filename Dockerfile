FROM pandeiro/lein:latest

COPY . /tmp/
WORKDIR /tmp

# Configs and data to be able to run without volumes for testing
RUN cp -r /tmp/config /app/.
RUN cp /tmp/cloju-cv.properties /app/.

RUN lein deps
RUN lein uberjar

RUN cp /tmp/target/clojucv-0.1.0-SNAPSHOT-standalone.jar /app/.

RUN rm -rf /tmp/*

WORKDIR /app
EXPOSE 8085
ENTRYPOINT []
CMD ["java", "-jar", "/app/clojucv-0.1.0-SNAPSHOT-standalone.jar"]