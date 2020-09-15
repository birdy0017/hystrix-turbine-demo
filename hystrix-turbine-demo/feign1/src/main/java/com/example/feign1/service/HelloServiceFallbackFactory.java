package com.example.feign1.service;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
@Component
public class HelloServiceFallbackFactory implements

        FallbackFactory<com.example.feign1.service.HelloService> {
@Override
public com.example.feign1.service.HelloService create(Throwable throwable) {
        return new com.example.feign1.service.HelloService() {
@Override
public String sayHiFromClientOne(String name) {
        return name +"！"+ throwable.toString();
        }
        };
        }
        }