package com.malin.demo.contorller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.malin.demo.config.DateUtil;
import com.malin.demo.config.FileUtil;

@Controller
//@CrossOrigin(origins = "*",maxAge = 3600)
public class IndexController {
	
	@RequestMapping(value = "/heelo",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject   hrrlo(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception {
		String trueFileName = file.getOriginalFilename();  
		System.out.println(trueFileName);
		 String userImageFilePath="E://userImages//";
	        System.out.println("--"+userImageFilePath);
		
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        String newFileName=DateUtil.getCurrentDateStr()+suffix;
        File destFile =new File(userImageFilePath+newFileName);
        
        FileUtil.uploadFile(file.getBytes(), userImageFilePath, newFileName);
		System.out.println(destFile);
		
        System.out.println(suffix);
        Map<String, Object> map =new HashMap<String, Object>();
      //虚拟路径(是需要保存到数据库中的)
		String filePath="/userImage/"+newFileName;
		
		String Path="http://www.king.com/aoda-web/"+filePath;
        JSONObject json =new JSONObject();
        json.put("url", Path);
        json.put("success", 1);
        json.put("message", "upload success!");
        System.out.println(json.toJSONString());
        System.out.println(json);
        System.out.println(map);
		return json;
	}

	
	
	@RequestMapping(value = "/uploadUser",method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin(origins = "*") 
	public JSONObject uploadUser(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(!file.isEmpty()){
			// 获取文件名
			String fileName = file.getOriginalFilename();
			//
			String userImageFilePath="E://userImages//";
			
			System.out.println("--"+userImageFilePath);
			// 获取文件的后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			String newFileName=DateUtil.getCurrentDateStr()+suffixName;
			File destFile =new File(userImageFilePath+newFileName);
			FileUtil.uploadFile(file.getBytes(), userImageFilePath, newFileName);
			System.out.println(destFile);
			//虚拟路径(是需要保存到数据库中的)
			String filePath="/userImage/"+newFileName;
			 JSONObject json =new JSONObject();
		        json.put("url", filePath);
		        json.put("success", 1);
		        json.put("message", "upload success!");
		        System.out.println(json.toJSONString());
		        System.out.println(json);
			 return json;	
		}else {
			 return null;	
		}
		
	}
	
	@RequestMapping(value = "/heselo")
	@ResponseBody
	//@CrossOrigin
	public Map<String, Object>  hrsrlo( String tiet, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println(tiet);
     String s=   new String(tiet.getBytes("iso-8859-1"),"utf-8");
     System.out.println(s);
       // String fileName = System.currentTimeMillis()+"_"+CommonUtils.getRandomNumber(100, 999)+suffix;  
        JSONObject json =new JSONObject();
        json.put("tiet",s );
        json.put("success", tiet);
		return json;
	}
	
	
	
	
	
	@RequestMapping(value = "/heeleo")
	@ResponseBody
	//@CrossOrigin
	public Map<String, Object>  hrrloe(@RequestParam("file") MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		String trueFileName = file.getOriginalFilename();  
		System.out.println(trueFileName);
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        
        System.out.println(suffix);
       // String fileName = System.currentTimeMillis()+"_"+CommonUtils.getRandomNumber(100, 999)+suffix;  
        Map<String, Object> map =new HashMap<String, Object>();
        Map<String, Object> map1 =new HashMap<String, Object>();
        JSONObject json =new JSONObject();
        map.put("errno", "0");
        map1.put("img", "/sds/sds.jpg");
        map.put("data", map1);
        JSONObject jsonObject = json.getJSONObject(map.toString());
        System.out.println(jsonObject);
        System.out.println(map);
		return map;
	}
	
	
	@RequestMapping(value = "/uploadUsers",method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin(origins = "*") 
	public String uploadUsers(@RequestParam(value = "myFileName", required = true) MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(!file.isEmpty()){
			// 获取文件名
			String fileName = file.getOriginalFilename();
			//
			String userImageFilePath="E://userImages//";
			
			System.out.println("--"+userImageFilePath);
			// 获取文件的后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			String newFileName=DateUtil.getCurrentDateStr()+suffixName;
			File destFile =new File(userImageFilePath+newFileName);
			FileUtil.uploadFile(file.getBytes(), userImageFilePath, newFileName);
			System.out.println(destFile);
			//虚拟路径(是需要保存到数据库中的)
			String filePath="/userImage/"+newFileName;
			 JSONObject json =new JSONObject();
			 
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("errno", 0);
			 map.put("data", filePath);
			 
			 String jsonString = JSONObject.toJSONString(map);
			 System.out.println(jsonString);
			 return jsonString;	
		}else {
			 return null;	
		}
		
	}
	//@RequestParam、@PathVariable
	
	@RequestMapping(value = "/file/upload")
	@ResponseBody
	@CrossOrigin(origins = "*") 
	public String uplsoad(@RequestParam(value = "file") MultipartFile file) throws Exception {
		System.out.println(file.getName());
		String originalFilename = file.getOriginalFilename();
		System.out.println(originalFilename);
		
		JSONObject json =new JSONObject();
			 
			 Map<String, Object> map=new HashMap<String, Object>();
			 map.put("errno", 0);
			 map.put("data", "/userImage/1.mp4");
			 String jsonString = JSONObject.toJSONString(map);
			 System.out.println(jsonString);
		return jsonString;
	}
	
	
}
