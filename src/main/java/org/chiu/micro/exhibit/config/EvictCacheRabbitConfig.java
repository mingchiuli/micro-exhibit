package org.chiu.micro.exhibit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mingchiuli
 * @create 2022-12-25 4:13 pm
 */
@Configuration
public class EvictCacheRabbitConfig {

    public static final String CACHE_BLOG_EVICT_QUEUE = "cache.blog.evict.queue";

    public static final String CACHE_BLOG_EVICT_EXCHANGE = "cache.blog.direct.exchange";

    public static final String CACHE_BLOG_EVICT_BINDING_KEY = "cache.blog.evict.binding";

    @Bean("cacheBlogEvictQueue")
    Queue queue() {
        return new Queue(CACHE_BLOG_EVICT_QUEUE, true, false, false);
    }

    @Bean("cacheBlogEvictExchange")
    DirectExchange exchange() {
        return new DirectExchange(CACHE_BLOG_EVICT_EXCHANGE, true, false);
    }

    @Bean("cacheBlogEvictBinding")
    Binding binding(@Qualifier("cacheBlogEvictQueue") Queue esQueue,
                    @Qualifier("cacheBlogEvictExchange") DirectExchange esExchange) {
        return BindingBuilder
                .bind(esQueue)
                .to(esExchange)
                .with(CACHE_BLOG_EVICT_BINDING_KEY);
    }
}
