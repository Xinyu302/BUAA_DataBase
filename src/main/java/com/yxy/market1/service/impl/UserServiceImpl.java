package com.yxy.market1.service.impl;

import com.yxy.market1.entity.User;
import com.yxy.market1.entity.dto.form.UserLoginForm;
import com.yxy.market1.entity.dto.form.UserRegisterForm;
import com.yxy.market1.mapper.UserMapper;
import com.yxy.market1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper mMapper;

    @Override
    public User loginAuthentication(UserLoginForm loginForm) {
//        List<User> userList =
        return null;
    }

    @Override
    public boolean registerUsernameCheckExist(UserRegisterForm registerForm) {
        return false;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void joinSession(HttpServletRequest request, User user) {

    }

    @Override
    public void destroySession(HttpServletRequest request) {

    }
}
