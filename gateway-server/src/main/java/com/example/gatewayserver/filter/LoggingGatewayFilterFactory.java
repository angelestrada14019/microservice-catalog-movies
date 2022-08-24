package com.example.gatewayserver.filter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class LoggingGatewayFilterFactory extends
        AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    final Logger logger =
            LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);

    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        // ...
        return (exchange, chain) -> {
            logger.info("Pre Logging");
            // Pre-processing

                logger.info("Pre GatewayFilter logging: " + exchange.getRequest().getPath().value());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {

                    logger.info("Post GatewayFilter logging: " + exchange.getRequest().getPath().value());

            }));
        };
    }


    public static class Config {
        // ...

    }
}
