package com.example.feign.service;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
@Component
public class HelloServiceFallbackFactory implements

        FallbackFactory<HelloService> {
@Override
public HelloService create(Throwable throwable) {
        return new HelloService() {
@Override
public String sayHiFromClientOne(String name) {
        return name +"！"+ throwable.toString();
        }
        };
        }
        }