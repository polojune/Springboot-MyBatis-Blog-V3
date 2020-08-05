package com.cos.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.Reply;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.service.ReplyService;



@Controller
//@RequiredArgsConstructor
public class ReplyController {
       
//	 private final PostService postService;
	
	
//     public PostController(PostService postService) {
//		this.postService = postService;
//	}
	@Autowired
	private ReplyService replyService;
	@Autowired
	private ReplyRepository replyRepository;
	
	
	
	 
	 @PostMapping("/reply")
	 public @ResponseBody CommonRespDto<?> replyProc(@RequestBody Reply reply) {
		 replyService.댓글쓰기(reply);
		 return new CommonRespDto<String>(1,"댓글쓰기 성공");
	 }
	 //post관련된 것은 전부다 인증 필요
	 @GetMapping("/replies")
	 public String getPosts(Model model){
		 model.addAttribute("replies",replyService.댓글보기());
		 return "index";
	 }
	 //매개변수로 데이터를 받을 수 있다.
	 //?주소 ㅡ>쿼리스트링 받는 것 
	 // /post/{id} ㅡ>파라미터를 받는 것
//	 @GetMapping("/post/{id}")
//	 public String getPost(@PathVariable int id,Model model) {
//		model.addAttribute("postDetailRespDto",postService.상세보기(id));
//		return "post/detail";
//	 }
//
//	 @DeleteMapping("/post/{id}") 
//	 public @ResponseBody CommonRespDto<?> deleteProc(@PathVariable int id,HttpSession session) throws MyRoleException{
//		  //세션 값 확인, 글의 주인 
//		  User principal = (User) session.getAttribute("principal");
//		  Post postEntity = postRepository.findOne(id);
//		  if(principal.getId()!= postEntity.getUserId()) {
//			   throw new MyRoleException();
//		  }
//		  postService.글삭제(id);
//		  return new CommonRespDto<String>(1,"글삭제 성공");
//	 }
//	 @PutMapping("/post/{id}") 
//	 public @ResponseBody CommonRespDto<?> update(@RequestBody Post post){
//		  postService.글수정(post);
//		  return new CommonRespDto<String>(1,"글수정 성공");
//	 }
}
