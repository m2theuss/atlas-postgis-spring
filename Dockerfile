#mvn compilation
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# this allow to reuse the cache of the dependency
COPY pom.xml .
RUN mvn dependency:go-offline

# copy the source code and generates the .jar file
COPY src ./src
RUN mvn clean package -DskipTests

# since using "from" this delete all thigs that happen in the end of that from keep just the important things
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

#copy just the jar files generates above
COPY --from=build /app/target/*.jar app.jar

#expose and run the program
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
