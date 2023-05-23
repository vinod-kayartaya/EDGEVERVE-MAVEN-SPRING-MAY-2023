# Apache Maven

- build automation tool
  - compile, run unit tests, create jar files, deploy to maven repositories etc
- manages project dependencies
  - maven provides a central repository of reusable maven projects (artifacts)
    - https://mvnrepository.com
  - jar files are organized into folders, representing the group and artifact ids
  - For example,
    - group id: "com.mysql"
    - one of the artifacts under this group: "mysql-connector-j"
    - each artifact may have multiple versions. one of the versions for the above artifact is: "8.0.33"
  - A jar file corresponding to this artifact is placed in the maven central server in this folder structure:
    - repository/com/mysql/mysql-connector-j/8.0.33/mysql-connector-j-8.0.33.jar
    - repository/com/mysql/mysql-connector-j/8.0.32/mysql-connector-j-8.0.32.jar
    - repository/com/mysql/mysql-connector-j/8.0.31/mysql-connector-j-8.0.31.jar
- consistent project structure
  - promotes a single project structure for all kinds of Java projects
    - spring, spring boot
    - struts
    - JSF
    - web projects
    - JavaFx
    - core java
    - hibernate and so on
  - across IDEs
    - eclipse, NetBeans, IntelliJ IDEA or many other IDEs
- Lifecycle plugins
  - maven defines a set of build life cycles
  - these dictate order of executing many tasks
    - compile, test, package, deploy, site etc.
- supports CI/CD
- Large community support

## Maven ArcheTypes

- template projects for creating new projects with predefined structures, configuration, and some default initial files
- We can use the command `mvn archetype:generate` to generate an entire project
    - We have to supply some of these options:
        -DgroupId=com.edgeverve
        -DartifactId=java-hello-world
        -DarcheTypeArtifactId=maven-archetype-quickstart
        -DinteractiveMode=false

    ```sh
    mvn archetype:generate \
        -DgroupId=com.edgeverve \
        -DartifactId=java-hello-world \
        -DarcheTypeArtifactId=maven-archetype-quickstart \
        -DinteractiveMode=false

    # on windows:
    mvn archetype:generate -DgroupId=com.edgeverve -DartifactId=java-hello-world -DarcheTypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
    ```

    Example for creating a apache struts2 project

    ```sh
    mvn archetype:generate \
        -DgroupId=com.edgeverve \
        -DartifactId=hello-struts2 \
        -DarchetypeGroupId=org.apache.struts \
        -DarchetypeArtifactId=struts2-archetype-convention \
        -DinteractiveMode=false
    ```

