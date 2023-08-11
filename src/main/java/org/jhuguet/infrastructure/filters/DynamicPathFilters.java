package org.jhuguet.infrastructure.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class DynamicPathFilters extends AbstractGatewayFilterFactory<DynamicPathFilters.Config> {

    public DynamicPathFilters() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String pathVariable = exchange.getAttribute(config.getPathVariable());
            exchange.getAttributes()
                    .put("pathVariable", pathVariable);
            exchange.getRequest()
                    .mutate()
                    .path("/" + pathVariable)
                    .build();
            return chain.filter(exchange);
        };
    }

    public static class Config {
        private String pathVariable;

        public String getPathVariable() {
            return pathVariable;
        }

        public void setPathVariable(String pathVariable) {
            this.pathVariable = pathVariable;
        }
    }

}
