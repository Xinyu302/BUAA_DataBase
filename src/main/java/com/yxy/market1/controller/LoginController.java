package com.yxy.market1.controller;

import com.yxy.market1.controller.base.BaseController;
import com.yxy.market1.entity.User;
import com.yxy.market1.entity.dto.form.UserLoginForm;
import com.yxy.market1.entity.dto.form.UserRegisterForm;
import com.yxy.market1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.yxy.market1.consts.ViewConsts.VIEW_MSG;
@Controller
public class LoginController extends BaseController {
    @Autowired
    private IUserService mUserService;

    /**
     * 前台用户登录
     * 表单提交
     */
    @PostMapping("/userlogin.f")
    public String fFrontUserLogin(HttpServletRequest request, Model model,UserLoginForm loginForm, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            addModelAtt(model, VIEW_MSG, errors.get(0).getDefaultMessage());
            return "userlogin";
        }
        User user = mUserService.loginAuthentication(loginForm);
        if (null != user) {
            mUserService.joinSession(request, user);
            return "redirect:/";
        }
        addModelAtt(model, VIEW_MSG, "用户名或密码错误");
        return "userlogin";
    }

    /**
     * 前台用户注册
     * 表单提交
     */
    @PostMapping("/userregister.f")
    public String fFrontUserRegister(UserRegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request, Model model, User user) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            return "redirect:/userregister";
        }
        //再次进行重名校验
        if (mUserService.registerUsernameCheckExist(registerForm)) {
            return "redirect:/userregister";
        }
        //再次进行密码一致校验
        if (!(registerForm.getPassword().equals(registerForm.getConfirmpassword()))) {
            return "redirect:/userregister";
        }
        mUserService.insertUser(user);
        //跳转登录
        return "redirect:/userlogin";
    }

    @GetMapping("/usersignout.c")
    public String cFrontUserSignout(HttpServletRequest request) {
        mUserService.destroySession(request);
        return "redirect:index";
    }
}
