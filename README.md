# Spring Boot H2 Database and Redis DEMO

This project runs Spring, H2 database and Redis as cache and pub/sub.

## Run the application

## Method 1 : Step docker-compoe
docker-compose -f docker-compose.yaml up.

## Method 2 : Run each component
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
see https://hub.docker.com/repository/docker/sophianachiba/angular_crud_demo
```

## Access the application
## Using PostMan
    GET/POST/DELETE: http://localhost:8080/api/tutorials
## Using UI
    http://localhost:8081/
# Building docker and push
```
mvn clean package
`docker build .`
`docker tag #ID sophianachiba/angular-crud-demo`
`docker push sophianachiba/angular-crud-demo`
```

