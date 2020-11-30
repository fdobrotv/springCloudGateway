//package com.fdobrotv.spring.gateway.base.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import reactor.core.publisher.Mono;
//
//import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
//import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Service
//public class SomeService {
//    private static final Logger LOG = LoggerFactory.getLogger(SomeService.class);
//
//    private final WebClient webClient;
//    private final ReactiveCircuitBreaker readingListCircuitBreaker;
//
//    public SomeService(ReactiveCircuitBreakerFactory circuitBreakerFactory) {
//        this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
//        this.readingListCircuitBreaker = circuitBreakerFactory.create("recommended");
//    }
//
//    public Mono<String> readingList() {
//        return readingListCircuitBreaker.run(webClient.get().uri("/recommended").retrieve().bodyToMono(String.class), throwable -> {
//            LOG.warn("Error making request to some service", throwable);
//            return Mono.just("Sorry but this service is currently unavailable");
//        });
//    }
//}