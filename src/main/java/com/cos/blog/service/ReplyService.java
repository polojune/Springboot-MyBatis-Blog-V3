package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Reply;
import com.cos.blog.repository.ReplyRepository;



@Service 
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository; 

	@Transactional
	public void 댓글쓰기(Reply reply) {
        
		replyRepository.save(reply);
         
	}
	
	@Transactional(readOnly = true)
	public List<Reply> 댓글보기() {
        
	  return replyRepository.findAll();

	}
	
//	@Transactional(readOnly = true)
//	public PostDetailRespDto 상세보기(int id) {
//        
//	  return postRepository.findById(id);
//
//	}
//	
//	@Transactional
//	public void 글삭제(int id) {
//        
//		postRepository.delete(id);
//         
//	}
//	@Transactional
//	public void 글수정(Post post) {
//        
//		postRepository.update(post);
//         
//	}
	
}
