FROM maven:3.9-eclipse-temurin-17

WORKDIR /app
COPY pom.xml ./
COPY src ./src

RUN mvn dependency:resolve
RUN mvn dependency:copy-dependencies -DoutputDirectory=./lib
RUN mvn install
RUN mv target/*.jar .

ENTRYPOINT ["java", "-jar","radon-listener-1.0.jar"]