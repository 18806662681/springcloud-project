package com.yanger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableHystrix // 开启hystrix功能
@EnableEurekaClient
@SpringBootApplication // 声明一个springboot项目
@ComponentScan("com.yanger.*") // 扫描注解的路径，可不配置，不配置则默认扫描启动类同包下的文件
@MapperScan("com.yanger.*.dao") // 引入项目中mybatis的mapper类
public class UserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}
	
	// RestTemplate进行服务间调用
	@Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

