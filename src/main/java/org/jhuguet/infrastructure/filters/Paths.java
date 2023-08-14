package org.jhuguet.infrastructure.filters;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

public interface Paths {
    default ServerHttpRequest createDynamicPath(String variable, ServerWebExchange exchange) {
        return exchange.getRequest().mutate().path("/" + variable).build();
    }
}
