package com.yxy.market1.service;

import com.yxy.market1.entity.User;
import com.yxy.market1.entity.dto.form.UserLoginForm;
import com.yxy.market1.entity.dto.form.UserRegisterForm;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息操作接口
 */
public interface IUserService {
    /**
     * 进行登录验证
     *
     * @param loginForm 登录表单
     *
     * @return 如果验证通过返回 User 实体
     */
    User loginAuthentication(UserLoginForm loginForm);

    /**
     *
     *
     */
    boolean registerUsernameCheckExist(UserRegisterForm registerForm);

    void insertUser(User user);

    void joinSession(HttpServletRequest request,User user);

    void destroySession(HttpServletRequest request);
}