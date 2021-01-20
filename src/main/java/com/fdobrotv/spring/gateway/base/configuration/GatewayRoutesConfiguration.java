package com.fdobrotv.spring.gateway.base.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.factory.TokenRelayGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfiguration {

    @Autowired
    private TokenRelayGatewayFilterFactory filterFactory;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder,
                                      UriConfiguration uriConfiguration) {
        String httpUri = uriConfiguration.getHttpbin();
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.readme.io")
                        .filters(f -> f.circuitBreaker(config ->
                                config.setName("mycmd").setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .route("resource", r -> r.path("/resource")
                        .filters(f -> f.filters(filterFactory.apply())
                                .removeRequestHeader("Cookie")) // Prevents clients cookie being sent downstream
                        .uri("http://clientService:9000")) // Taking advantage of docker naming
                .build();
    }
}
