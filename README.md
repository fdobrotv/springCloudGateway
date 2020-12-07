# Getting Started
This is the base Spring Cloud Gateway project, from date of 30.11.2020

## Requirements
Java 15, Gradle 6.6+

Docker, docker-compose

### Host name aliases in hosts file
cat `127.0.0.1 gateway-service-1.com` >> /etc/hosts

## Prepare environment to run
1 - Launch discovery service
`git clone https://github.com/fdobrotv/springDiscoveryService.git`

`cd springDiscoveryService`

`docker-compose up`

## Build, test and run
`gradlew build`
`gradlew jib`

### Run locally
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

### Gateway filter examples
https://github.com/eugenp/tutorials/tree/master/spring-cloud/spring-cloud-gateway/src/main/java/com/baeldung/springcloudgateway/customfilters/gatewayapp/filters/factories
https://spring.io/blog/2019/07/01/hiding-services-runtime-discovery-with-spring-cloud-gateway
https://github.com/benwilcock/spring-cloud-gateway-demo/blob/master/runtime-discovery/docker-compose.yml