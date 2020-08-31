package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	// 기본적으로 User는 x-www-form-urlencode-type만 받을 수 있다. json타입으로 받으려면 RequestBody를
	// 붙여줘야한다.
	// 메세지 컨버터가 실행되서 json 데이터를 java 객체로 바꿔 준다.(@RequestBody라고 하면 메세지 컨버터를 json
	// 컨버터로(jackson이 실행) 바뀐다.)
	@PostMapping("/auth/joinProc")
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) {
		userService.회원가입(user);
		return new CommonRespDto<String>(1, "회원가입성공");
	}

	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session) {
		User persistUser = userService.로그인(user);

		if (ObjectUtils.isEmpty(persistUser)) {
			System.out.println("없음");
			return new CommonRespDto<String>(-1, "로그인 실패");
		} else {
			System.out.println("있음");
			// 세션 등록해야함
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1, "로그인 성공");
		}

	}
	@GetMapping("/user/update")
	public String updateUserInfo() {
		return "/user/updateForm";
	}


	@PostMapping("/user/updateProc")
	public @ResponseBody CommonRespDto<?> updateUserInfoProc(@RequestBody User user) {
		userService.회원정보수정(user);
		return new CommonRespDto<String>(1, "회원정보 수정 성공");
	}
	

}
