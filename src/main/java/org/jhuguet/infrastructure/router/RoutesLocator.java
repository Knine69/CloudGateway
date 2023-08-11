package org.jhuguet.infrastructure.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RoutesLocator {

    @Bean
    public RouteLocator postRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("SimplePostIdentification", route ->
                        route.path("/gateway/post/**")
                                .filters(f -> f.setPath("/singular"))
                                .uri("http://localhost:8080")
                )
                .build();
    }
}
