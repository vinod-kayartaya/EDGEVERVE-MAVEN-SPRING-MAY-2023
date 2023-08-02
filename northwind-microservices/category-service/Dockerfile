from maven:3-eclipse-temurin-17-alpine
workdir /vinod/worksapce
copy . .
run mvn clean package -DskipTests

cmd ["java", "-jar", "target/category-service-0.0.1-SNAPSHOT.jar"]
expose 8080

