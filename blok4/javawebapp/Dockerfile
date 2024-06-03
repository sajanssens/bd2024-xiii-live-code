FROM tomcat:10-jre21-temurin-jammy
ADD target/javawebapp.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
