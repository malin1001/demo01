package com.malin.demo.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//@Configuration
public class CommonConfig {

	
	 //设置文件上传的配置
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver multipartResolver(){
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        resolver.setMaxUploadSize(52428800);
//        resolver.setResolveLazily(true);
//        return resolver;
//    }
//	 	@Bean
//	    public MultipartConfigElement multipartConfigElement() {
//	        MultipartConfigFactory factory = new MultipartConfigFactory();
//	        //文件最大
//	        
//	        factory.setMaxFileSize(DataSize.ofMegabytes(1024)); //KB,MB
//	        /// 设置总上传数据总大小
//	        factory.setMaxRequestSize(DataSize.ofMegabytes(1024));
//	        return factory.createMultipartConfig();
//	    }

}
