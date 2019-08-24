package com.limit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhou
 * @date 2019/8/18 20:19
 */
public class RemoteAddrKeyResolver implements KeyResolver {
    private static final Logger logger = LoggerFactory.getLogger(RemoteAddrKeyResolver.class);
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        logger.debug("token limit for ip {}", exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
