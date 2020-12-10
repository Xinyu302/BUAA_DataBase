package com.yxy.market1.controller;

import com.yxy.market1.entity.User;
import com.yxy.market1.entity.dto.form.AccountForm;
import com.yxy.market1.entity.dto.form.ModifyPassWordForm;
//import com.yxy.market1.entity.dto.form.UserLoginForm;
import com.yxy.market1.entity.dto.response.Result;
import com.yxy.market1.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountOperateController {
    @Autowired
    private IUserService mUserService;

    @PostMapping("/modify")
    public String modifyUserInfo(HttpServletRequest request, Model model, AccountForm accountForm, BindingResult bindingResult) throws Exception {
        User user = mUserService.getUserSession(request);

        return "modify";
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public Result changePassword(HttpServletRequest request, Model model, ModifyPassWordForm form) {
        if (form.getNewPassWord() != form.getConfirmPassWord()) {
            return Result.failure("两次密码输入不一致");
        }
        User user = mUserService.findUserByName(form.getUserName());
        if (user == null) {
            return Result.failure("用户不存在");
        }
        if (user.getPassword() == DigestUtils.md2Hex(form.getNewPassWord())) {
            return Result.failure("与原密码相同");
        }

        return Result.success();
    }


}
