package com.cos.blog.config.handler;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.handler.exception.MyRoleException;
import com.cos.blog.config.handler.exception.MySessionException;

@ControllerAdvice //IoC 등록됨 Exception을 낚아 채는 컨트롤러
@RestController
public class GlobalExceptionHandler {
      
	@ExceptionHandler(value=MyRoleException.class)
	public String roleException(Exception e) {
		//권한 없음
		return "<Script>alert('권한 없어요') </Script>";
	}
	@ExceptionHandler(value=MySessionException.class)
	public String sessionException(Exception e) {
		//권한 없음
		return "<h1>인증 안됐어요. </h1>";
	}
}
