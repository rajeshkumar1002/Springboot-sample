package com.incedo.blog.service.impl;

import com.incedo.blog.entity.Comments;
import com.incedo.blog.entity.Post;
import com.incedo.blog.repository.CommentsRepository;
import com.incedo.blog.repository.PostRepository;
import com.incedo.blog.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    CommentsRepository commentsRepository;

    @Override
    public Comments createComment(Long postId, Comments comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("resource not found"));
        comment.setPost(post);
        return commentsRepository.save(comment);
    }

    @Override
    public List<Comments> listCommentsByPostId(Long postId) {
        return commentsRepository.findByPostId(postId);
    }

    @Override
    public Comments viewComment(Long postId,Long id) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("resource not found"));
        Comments comment = commentsRepository.findById(id).orElseThrow(()-> new RuntimeException("resource not found"));
        if(!comment.getPost().getId().equals(post.getId())) throw new RuntimeException("comment does not belong to post");
        return commentsRepository.findById(id).orElseThrow(()-> new RuntimeException("resource not found"));
    }

    @Override
    public Comments updateComment(Long postId, Long commentId, Comments comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("resource not found"));
        Comments oldComment = commentsRepository.findById(commentId).orElseThrow(()-> new RuntimeException("resource not found"));
        if(!oldComment.getPost().getId().equals(post.getId())) throw new RuntimeException("comment does not belong to post");
        oldComment.setBody(comment.getBody());
        oldComment.setEmail(comment.getEmail());
        oldComment.setName(comment.getName());
        oldComment.setPost(post);
        return commentsRepository.save(oldComment);
    }

    @Override
    public void removeComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("resource not found"));
        Comments oldComment = commentsRepository.findById(commentId).orElseThrow(()-> new RuntimeException("resource not found"));
        if(!oldComment.getPost().getId().equals(post.getId())) throw new RuntimeException("comment does not belong to post");
        commentsRepository.deleteById(commentId);
    }
}
