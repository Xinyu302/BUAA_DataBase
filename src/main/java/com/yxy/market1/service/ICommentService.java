package com.yxy.market1.service;

import com.yxy.market1.entity.Comment;

import java.util.List;

public interface ICommentService {
    void saveComment(Comment comment);

    List<Comment> findCommentByProductId(Integer productid);
}
