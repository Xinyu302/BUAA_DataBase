package com.yxy.market1.mapper;

import com.yxy.market1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper extends JpaRepository<Comment,Integer> {
    @Query
    List<Comment> findCommentsByProductid(Integer productid);
}
