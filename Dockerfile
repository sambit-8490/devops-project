FROM ubuntu

WORKDIR /app

RUN apt-get update && apt install openjdk-17-jre maven git -y

RUN git clone https://github.com/siddudev/Maven_Sample_Project1.git .

COPY . .

RUn  mvn clean package

RUN cp  /app/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
