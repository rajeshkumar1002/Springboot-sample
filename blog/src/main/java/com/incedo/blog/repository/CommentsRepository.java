package com.incedo.blog.repository;

import com.incedo.blog.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,Long> {

    public List<Comments> findByPostId(Long postId);

}
