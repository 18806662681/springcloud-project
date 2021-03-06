package com.yanger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import brave.sampler.Sampler;

@EnableEurekaClient  //注册服务到eureka上
@SpringBootApplication // 声明一个springboot项目
@ComponentScan("com.yanger.*") // 扫描注解的路径，可不配置，不配置则默认扫描启动类同包下的文件
@MapperScan("com.yanger.*.dao") // 引入项目中mybatis的mapper类
public class BookServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServerApplication.class, args);
	}
	
	// zipkin依赖支持，不注入zipkin无法发现服务
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}

