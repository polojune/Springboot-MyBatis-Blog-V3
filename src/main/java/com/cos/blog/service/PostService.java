package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Post;
import com.cos.blog.model.User;
import com.cos.blog.repository.PostRepository;
import com.cos.blog.repository.UserRepository;



@Service 
public class PostService {

	@Autowired
	private PostRepository postRepository; 

	@Transactional
	public void 글쓰기(Post post) {
        
		postRepository.save(post);

	}
	
}
