package com.dh.movieservice.api.core.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {
    @Value("${queue.movie.name}")
    private String queueName;

    @Bean
    public Queue getNameQueue() {
        return new Queue(this.queueName, true);
    }
}
