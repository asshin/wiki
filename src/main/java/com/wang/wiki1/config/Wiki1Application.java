package com.wang.wiki1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@ComponentScan("com.wang")
@SpringBootApplication
public class Wiki1Application {

	private static final Logger LOG = LoggerFactory.getLogger(Wiki1Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Wiki1Application.class, args);

		Environment environment = run.getBean(Environment.class);
//		Environment env = app.run(args).getEnvironment();
		LOG.info("启动成功！！");
		LOG.info("地址: \thttp://127.0.0.1:{}", environment.getProperty("server.port"));
	}

}

