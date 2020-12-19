package com.yxy.market1.controller;

import com.yxy.market1.Utils.ResultUtil;
import com.yxy.market1.controller.base.BaseController;
import com.yxy.market1.entity.Comment;
import com.yxy.market1.entity.User;
import com.yxy.market1.entity.dto.response.CommentResponse;
import com.yxy.market1.entity.dto.response.Result;
import com.yxy.market1.service.ICommentService;
import com.yxy.market1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentController extends BaseController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IUserService userService;

    @PostMapping("add-comment")
    @ResponseBody
    public Result<Integer> addComment(HttpServletRequest request,Integer userId,Integer productId,String content) {
        Date date = new Date();
        Comment comment1 = new Comment();
        comment1.setContent(content);
        comment1.setProduct_id(productId);
        comment1.setTime(date);
        comment1.setUser_id(userId);
        commentService.saveComment(comment1);
        return ResultUtil.success(0);
    }

    @PostMapping("get-comment")
    @ResponseBody
    public Result<List<CommentResponse>> getCommentByProductId(HttpServletRequest request, Integer productid) {
        List<Comment> commentList = commentService.findCommentByProductId(productid);
        List<CommentResponse> responseList = new ArrayList<>();
        for (Comment comment : commentList) {
            Integer userId = comment.getUser_id();
            String user = userService.findNameById(userId);
            CommentResponse response = new CommentResponse();
            response.setContent(comment.getContent());
            response.setUsername(user);
            response.setDate(comment.getTime());
            responseList.add(response);
        }
        return ResultUtil.success(responseList);
    }
}
