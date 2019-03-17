package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 测试接口
 * 消费服务端接口
 * @author zhou 20190313 21:08:16
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 测试接口联通性
     * @param name
     * @return
     */
    public String test(String name) {
        return restTemplate.getForObject("http://MICROSERVICE-EUREKA-CLIENT/hi?name="+name, String.class);
    }
}
