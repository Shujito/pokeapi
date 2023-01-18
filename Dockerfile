FROM amazoncorretto:11-alpine as builder

WORKDIR /opt/app

COPY *.gradle gradle.* gradlew ./
COPY gradle gradle
COPY app/build.gradle app/build.gradle
COPY pokeapi/build.gradle pokeapi/build.gradle

RUN ./gradlew :pokeapi:clean --no-daemon

COPY . .

RUN ./gradlew :pokeapi:build --no-daemon

FROM amazoncorretto:11-alpine

WORKDIR /opt/data

COPY --from=builder /opt/app/pokeapi/build/libs/pokeapi.jar /opt/app/pokeapi.jar

CMD java -jar /opt/app/pokeapi.jar
