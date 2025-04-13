<<<<<<< HEAD
FROM ubuntu

WORKDIR /app

RUN apt-get update && apt install openjdk-17-jre maven git -y

RUN git clone https://github.com/siddudev/Maven_Sample_Project1.git .

COPY . .

RUn  mvn clean package

RUN cp  /app/target/*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
=======
# syntax=docker/dockerfile:1
FROM python:3.10-alpine
WORKDIR /code
ENV FLASK_APP=app.py
ENV FLASK_RUN_HOST=0.0.0.0
RUN apk add --no-cache gcc musl-dev linux-headers
COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt
EXPOSE 5000
COPY . .
CMD ["flask", "run", "--debug"]
>>>>>>> 2dcf426 (compose)
