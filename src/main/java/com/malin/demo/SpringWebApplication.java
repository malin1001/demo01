package com.malin.demo;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

@SpringBootApplication

@Configuration
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

	/**
	     * 文件上传配置
	     * @return
	     */
		@Bean
		public MultipartConfigElement multipartConfigElement() {
			MultipartConfigFactory factory = new MultipartConfigFactory();
			//文件最大
			factory.setMaxFileSize(DataSize.ofMegabytes(30)); //KB,MB
			/// 设置总上传数据总大小
			factory.setMaxRequestSize(DataSize.ofMegabytes(200));
			return factory.createMultipartConfig();

	}
	
}
