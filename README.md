# Getting Started
This is the base Spring Cloud Gateway project, from date of 30.11.2020

## Requirements
Java 15
Gradle 6.6+

## Build, test and run
`gradlew build`
`gradlew bootRun`

### Then test by hands
#### SomeService
`curl http://localhost:8080/get`
#### Fallback
`curl --dump-header - --header 'Host: resilience4j.readme.io' http://localhost:8080/delay/3`

## Base project
https://spring.io/guides/gs/gateway

## Cloud gateway documentation
https://cloud.spring.io/spring-cloud-gateway/reference/html

### Reference Documentation
https://spring.io/projects/spring-cloud-circuitbreaker