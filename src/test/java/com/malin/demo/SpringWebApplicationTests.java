package com.malin.demo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import com.malin.demo.config1.AliyunOSSUtil;


@SpringBootTest
class SpringWebApplicationTests {
	
	@Test
	void contextLoads() throws IOException {
		File file =new File("E:\\userImages\\20191206025652.jpg");
		
	//AliyunOSSUtil.upload(file, objectKey)
		//MultipartFile file = MultipartFile
		//File file =new File("E:\\articleImages/1.mp4");
		
		  String upload = AliyunOSSUtil.upload(file,"userImages");
		  System.out.println(upload);
//		  URL fileUrl = AliyunOSSUtil.fileUrl(upload);
//		  System.out.println("--------d------------------"+fileUrl);
		 
		
	}

}
