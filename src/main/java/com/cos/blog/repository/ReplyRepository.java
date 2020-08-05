package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.controller.dto.PostDetailRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.model.Reply;


public interface ReplyRepository {
     public void save(Reply reply);
     public List<Reply> findAll();
     public PostDetailRespDto findById(int id);
//     public void delete(int id);
//     public void update(Post post);
//     public Post findOne(int id);
}
