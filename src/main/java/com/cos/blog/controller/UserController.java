package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@Controller
public class UserController {
    
	 @Autowired
	 private UserService userService;
	
	 //기본적으로 User는 x-www-form-urlencode-type만 받을 수 있다. json타입으로 받으려면 RequestBody를 붙여줘야한다.
	 //메세지 컨버터가 실행되서 json 데이터를 java 객체로 바꿔 준다.(@RequestBody라고 하면 메세지 컨버터를 json 컨버터로(jackson이 실행) 바뀐다.)   
	@PostMapping("/auth/joinProc")             
	  public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user){ 
		userService.회원가입(user);
		return new CommonRespDto<String>(1,"회원가입완료");
	}
}
