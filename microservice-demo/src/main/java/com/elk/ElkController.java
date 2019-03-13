package com.elk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * ELK日志Demo
 * @RestController @RestController 此注解是代表当前类是一个Restful API的controller,不返回视图
 * @author zhou
 */
@RestController
@EnableAutoConfiguration
public class ElkController {
    private static final Logger LOG = LoggerFactory.getLogger(ElkController.class);
    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/elkdemo")
    public String helloWorld() {
        String response = "Hello user !" + new Date();
        LOG.info("/elkdemo - > " + response);

        return response;
    }

    @RequestMapping(value = "/exception")
    public String exception() {
        String rsp = "";
        try{
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Exception :: - > " , e);

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            LOG.error("Exception AS String :: - > " + stackTrace);
            rsp = stackTrace;
        }

        return rsp;
    }

    @RequestMapping(value = "/elk")
    public String helloWorld1() {

        String response = restTemplate.exchange("http://localhost:7001/elkdemo", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }).getBody();
        LOG.info("/elk - > " + response);

        try {
            String exceptionrsp = restTemplate.exchange("http://localhost:7001/exception", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
            }).getBody();
            LOG.info("/elk trying to print exception - > " + exceptionrsp);
            response = response + " === " + exceptionrsp;
        } catch (Exception e) {
            // exception should not reach here. Really bad practice :)
        }

        return response;
    }
}
