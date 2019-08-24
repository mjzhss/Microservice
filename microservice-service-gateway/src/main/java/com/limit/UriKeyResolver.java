package com.limit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhou
 * @date 2019/8/18 20:30
 */
public class UriKeyResolver implements KeyResolver {
    private static final Logger logger = LoggerFactory.getLogger(UriKeyResolver.class);
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        logger.debug("token limit for uri: {}",exchange.getRequest().getURI().getPath());
        return Mono.just(exchange.getRequest().getURI().getPath());
    }
}
