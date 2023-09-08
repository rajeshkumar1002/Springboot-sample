package com.incedo.blog.service;

import com.incedo.blog.entity.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentsService {

    public Comments createComment(Long postId,Comments comments);
    public List<Comments> listCommentsByPostId(Long postId);

    public Comments viewComment(Long postId,Long id);

    public Comments updateComment(Long postId,Long commentId, Comments comment);

    public void removeComment(Long postId, Long commentId);



}