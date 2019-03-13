package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController是一类特殊的@Controller，
 * 它的返回值直接作为HttpResponseBody部分返回给浏览器
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "hello";
    }

    @RequestMapping(value = "/loginGet", method = RequestMethod.GET)
    String loginGet() {
        return "Login Page";
    }

    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    String loginPost() {
        return "Login Post Page";
    }

    /**
     * url变量会被自动赋值给被@PathVariable注解的参数
     * 能够根据参数类型赋值
     * @param username
     * @return
     */
    @RequestMapping("/user/{username}")
    public String userProfile(@PathVariable("username") String username) {
        return String.format("user %s", username);
    }

    /**
     * 例如微博两个用户的个人主页对应两个不同url
     * 我们不能对每一个用户都编写一个被@RequestMapping注解的方式来处理请求
     * @RequestMapping等价@GetMapping
     * @param id
     * @return
     */
    @RequestMapping("/post/{id}")
    public String post(@PathVariable("id") int id) {
        return String.format("post %d", id);
    }

    public static void main(String[] args){
        SpringApplication.run(Example.class, args);
    }
}
