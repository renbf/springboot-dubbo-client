package com.yl.springbootdubboclient;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.yl.service.ISendService;

@SpringBootApplication
@EnableDubbo
@ComponentScan(basePackages="com.yl")
public class SpringbootDubboClientApplication {

//	@Reference(version = "1.0.0")
//  	private HelloService demoService;
	
	@Reference(version = "1.0.0",timeout=4000999)
	private ISendService sendService;
	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootDubboClientApplication.class, args);
	}
	
    @PostConstruct
    public void init() {
//    	String sayHello = demoService.sayHello("world");
//    	System.out.println(sayHello);
    	String sayHello = sendService.sayHello("rbfkafka");
    	System.out.println(sayHello);
    }
}
