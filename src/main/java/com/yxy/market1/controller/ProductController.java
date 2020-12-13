package com.yxy.market1.controller;

import com.yxy.market1.controller.base.BaseController;
import com.yxy.market1.entity.User;
import com.yxy.market1.entity.dto.form.UserLoginForm;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.yxy.market1.consts.ViewConsts.VIEW_LABEL;
import static com.yxy.market1.consts.ViewConsts.VIEW_MSG;

public class ProductController extends BaseController {



//    @PostMapping("/userlogin.f")
//    public String fFrontUserLogin(HttpServletRequest request, Model model, UserLoginForm loginForm, BindingResult bindingResult) throws Exception {
//        System.out.println("this func is called");
//        System.out.println("username is " + loginForm.getUsername());
//        System.out.println("username is " + loginForm.getPassword());
//        if (bindingResult.hasErrors()) {
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            addModelAtt(model, VIEW_MSG, errors.get(0).getDefaultMessage());
//            return "login-register";
//        }
//        User user = mUserService.loginAuthentication(loginForm);
//        if (null != user) {
////            System.out.println("login now");
//            mUserService.joinSession(request, user);
//            return "redirect:/";
//        }
//        addModelAtt(model, VIEW_LABEL, 1);
//        addModelAtt(model, VIEW_MSG, "用户名或密码错误");
//        return "login-register";
//    }
}
