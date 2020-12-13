package com.yxy.market1.service.impl;

import com.yxy.market1.consts.SessionConstants;
import com.yxy.market1.entity.User;
import com.yxy.market1.entity.dto.form.AccountForm;
import com.yxy.market1.entity.dto.form.ModifyPassWordForm;
import com.yxy.market1.entity.dto.form.UserLoginForm;
import com.yxy.market1.entity.dto.form.UserRegisterForm;
import com.yxy.market1.mapper.UserMapper;
import com.yxy.market1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper mMapper;

    @Override
    public User loginAuthentication(UserLoginForm loginForm) {
        List<User> userList = mMapper.findUserByNameAndPassword(loginForm.getUsername(),DigestUtils.md2Hex(loginForm.getPassword()));
        if (userList != null && userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public boolean registerUsernameCheckExist(UserRegisterForm registerForm) {
        List<User> userList = mMapper.findUserByName(registerForm.getUsername());
        return (userList != null && userList.size() == 1);
//        return false;
    }

    @Override
    public void insertUser(User user) {
        String pwdStr = user.getPassword();
        user.setPassword(DigestUtils.md2Hex(pwdStr));
        mMapper.save(user);
    }

    @Override
    public void joinSession(HttpServletRequest request, User user) {
        HttpSession requestSession = request.getSession(true);
        requestSession.setAttribute(SessionConstants.SESSION_CURRENT_USER, user);
    }

    @Override
    public User getUserSession(HttpServletRequest request) {
        HttpSession requestSession = request.getSession(false);
        return (User) requestSession.getAttribute(SessionConstants.SESSION_CURRENT_USER);
    }

    @Override
    public void destroySession(HttpServletRequest request) {
        HttpSession requestSession = request.getSession(true);
        requestSession.removeAttribute(SessionConstants.SESSION_CURRENT_USER);
    }

    @Override
    public void modifyUserPassword(HttpServletRequest request, User user, ModifyPassWordForm modifyPassWordForm) {

    }

    @Override
    public User findUserByName(String username) {
        List<User> userList = mMapper.findUserByName(username);
        if (userList != null && userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public void changePassWord(String username, String password) {

    }

    @Override
    public void modifyUserInfo(HttpServletRequest request, User user) {
        mMapper.save(user);
    }
}
