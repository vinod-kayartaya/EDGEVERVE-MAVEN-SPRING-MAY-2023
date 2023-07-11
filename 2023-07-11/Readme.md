# Different ways to override the values of `application.properties` file in the JAR file

1. keep a new `application.properties` (or `application.yaml`) file in the same directory where you are executing the `java -jar app.jar` command

2. add an environment variable in the shell (command prompt or terminal)

Windows:

```sh
set SERVER_PORT=3456
java -jar app.jar
```

Linux/macOS:

```sh
export SERVER_PORT=2345
java -jar app.jar
```

assuming that the `application.properties` uses an environment variable

Example application.properties:

```properties
server.port=${SERVER_PORT:8080}
banner=banner.txt
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:tcp://${DB_HOST:localhost}/~/${DB_NAME:northwind}
spring.datasource.username=${DB_USER:root}
spring.datasource.password=${DB_PASSWORD:Welcome#123}
```

3. Specify the environment variable along with the java command itself:

```sh
SERVER_PORT=7788 && java -jar app.jar
```
