package org.jhuguet.infrastructure.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class DynamicPathFilters extends AbstractGatewayFilterFactory<Object> implements Paths {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            String variable = exchange.getRequest()
                    .getPath()
                    .value()
                    .replace("/gateway/dynamic/", "");

            return chain.filter(exchange.mutate().request(createDynamicPath(variable, exchange)).build());
        };
    }
}
