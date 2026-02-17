FROM tomcat:10.1-jdk21
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} /usr/local/tomcat/webapps/ROOT.war
HEALTHCHECK --interval=10s --timeout=5s --start-period=10s --retries=5 CMD curl -f http://localhost:8080/personas || exit 1
