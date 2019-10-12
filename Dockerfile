FROM maven:3-jdk-8 as builder
MAINTAINER SpringTeam
COPY . /apps
WORKDIR /apps
RUN mvn clean package
RUN scp ./target/demo.war /demo.war

FROM tomcat:8.5
WORKDIR /
COPY --from=builder demo.war /usr/local/tomcat/webapps/demo.war
RUN apt-get update && \
  apt-get install -y \
    net-tools \
    tree \
    vim && \
  rm -rf /var/lib/apt/lists/* && apt-get clean && apt-get purge
RUN echo "export JAVA_OPTS=\"-Dapp.env=staging\"" > /usr/local/tomcat/bin/setenv.sh
EXPOSE 8080
CMD ["catalina.sh", "run"]
