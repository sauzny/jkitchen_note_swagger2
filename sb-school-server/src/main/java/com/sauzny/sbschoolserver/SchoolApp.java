package com.sauzny.sbschoolserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class SchoolApp {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SchoolApp.class);
		// 打印PID
		// 配置文件中可以设置文件打印路径，文件默认位置是项目当前目录application.pid
		// 执行测试用例的话，是不执行此处代码的
		app.addListeners(new ApplicationPidFileWriter());
		app.run(args);
	}
}
