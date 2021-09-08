# crud_database_jdbc

CRUD Console application.
Java, MySQl, Hibernate, Flyway, Maven.

How to use:

1. Clone or Download repository
2. Go to project directory
3. Run `mvn clean flyway:migrate -Dflyway.configFile=myFlywayConfig.properties`
4. Run `mvn install`
5. Run `mvn exec:java -Dexec.mainClass="StartProgram"`
