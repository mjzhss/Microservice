package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
     * HystrixCommand创建熔断器功能,并指定fallbackMethod方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "testError")
    public String test(String name) {
        return restTemplate.getForObject("http://MICROSERVICE-EUREKA-CLIENT/hi?name="+name, String.class);
    }

    public String testError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
