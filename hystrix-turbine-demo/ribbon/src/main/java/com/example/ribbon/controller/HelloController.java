package com.example.ribbon.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class HelloController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/hi")
    //使用断路器
    @HystrixCommand(fallbackMethod = "ErrorMethod")
    public String hi(@RequestParam String name){
        return
                restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
    //当服务不可用时会调用此方法并返回
    public String ErrorMethod(String name){
        return name + ", 这里是断路器返回的错误内容";
    }
}