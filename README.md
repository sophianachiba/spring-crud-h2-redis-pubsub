# Spring Boot H2 Database and Redis DEMO

This project runs Spring, H2 database and Redis as cache and pub/sub.

## Run the application

## 1- Run Redis
```
docker run --name my-redis -p 6379:6379 -d redis
```
## 2- Run Spring Boot
```
mvn spring-boot:run
```
## 3- Run Angular (Optional)
```

```
# Running using Docker-compse.
```
docker-compose -f docker-compose.yaml up
```

## Access the application
## Using PostMan
    GET/POST/DELETE: http://localhost:8080/api/tutorials
## Using UI
    http://localhost:8081/
# Building docker
```
mvn clean package
build --tag=spring-boot-jpa:latest .
```

