package com.yuanting.Blog.controller;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
 

import io.swagger.models.Path;
 

@Controller
public class FileController {
 /*
	 @RequestMapping("/uploadImg")
	 public @ResponseBody Map<String, Object> uploadImg(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file,
			 				HttpServletRequest request) {
	       Map<String,Object> resultMap = new HashMap<String,Object>();
	        String fileName = file.getOriginalFilename();
	        //保存
	        try {
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	            resultMap.put("success", 1);
	            resultMap.put("message", "上传成功！");
	            resultMap.put("url","../images/"+fileName);
	        } catch (Exception e) {
	            resultMap.put("success", 0);
	            resultMap.put("message", "上传失败！");
	            e.printStackTrace();
	        } 
	        return resultMap; 
	 }
	 */
}
