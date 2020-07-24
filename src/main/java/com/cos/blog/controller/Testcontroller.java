package com.cos.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {
      
      
	  @GetMapping("/user/{id}") 
	  public String findUser() {
		  return"<h1>유저 찾기 페이지</h1>";
	  }
	   //인증 필요없음
	  @GetMapping("/post/{id}") 
	  public String findPost() {
		  return"<h1>글 상세보기페이지</h1>";
	  }
	  //인증 필요 + 관리자 권한  필요 
	  @GetMapping("/admin") 
	  public String admin() {
		  return"<h1>관리자 페이지</h1>";
	  }
	  
	 
}
