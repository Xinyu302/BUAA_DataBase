package com.yxy.market1.service.impl;

import com.yxy.market1.entity.Comment;
import com.yxy.market1.mapper.CommentMapper;
import com.yxy.market1.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void saveComment(Comment comment) {
        commentMapper.save(comment);
    }

    @Override
    public List<Comment> findCommentByProductId(Integer productid) {
        return commentMapper.findCommentsByProduct_id(productid);
    }
}
