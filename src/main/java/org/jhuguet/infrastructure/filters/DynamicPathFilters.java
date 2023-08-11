package org.jhuguet.infrastructure.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class DynamicPathFilters extends AbstractGatewayFilterFactory<DynamicPathFilters> {

    @Override
    public GatewayFilter apply(DynamicPathFilters config) {
        return (exchange, chain) -> {
            String variable = exchange.getRequest()
                    .getPath()
                    .value();
            exchange.getRequest()
                    .mutate()
                    .path("/" + variable)
                    .build();
            return chain.filter(exchange);
        };

    }
}
