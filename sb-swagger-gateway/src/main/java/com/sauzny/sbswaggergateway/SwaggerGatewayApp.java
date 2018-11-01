package com.sauzny.sbswaggergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerGatewayApp {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SwaggerGatewayApp.class);
		// 打印PID
		// 配置文件中可以设置文件打印路径，文件默认位置是项目当前目录application.pid
		// 执行测试用例的话，是不执行此处代码的
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}
}
