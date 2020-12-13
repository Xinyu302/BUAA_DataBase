package com.yxy.market1.controller;

import com.yxy.market1.Utils.ResultUtil;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountOperateController {
    @Autowired
    private IUserService mUserService;

    @PostMapping("/modifyuser")
    @ResponseBody
    public Result<Integer> modifyUserInfo(HttpServletRequest request, Model model, AccountForm accountForm, BindingResult bindingResult) throws Exception {
        System.out.println("enter modify");
        User user = mUserService.findUserByName(accountForm.getsUserName());
        if (user.getAddress() == accountForm.getAddress() && user.getAge() == accountForm.getAge() &&
            user.getGender() == accountForm.getGender() && user.getEmail()
                == accountForm.getEmail()) {
            return new Result<Integer>(200,"Success",0);
        }
        user.setAddress(accountForm.getAddress());
        user.setEmail(accountForm.getEmail());
        user.setGender(accountForm.getGender());
        user.setAge(accountForm.getAge());
        mUserService.modifyUserInfo(request, user);
        mUserService.joinSession(request, user);
        return new Result<Integer>(200,"Success",0);
    }

    @PostMapping("/changepassword")
    @ResponseBody
    public Result changePassword(HttpServletRequest request, Model model, ModifyPassWordForm form) {
        if (form.getNewPassWord() != form.getConfirmPassWord()) {
            return new Result<Integer>(500,"两次密码输入不一致",0);
        }
        User user = mUserService.findUserByName(form.getUserName());
        if (user == null) {
            return new Result<Integer>(500,"用户不存在",0);
//            return Result.failure("用户不存在");
        }
        if (user.getPassword() == DigestUtils.md2Hex(form.getNewPassWord())) {
            return new Result<Integer>(500,"与原密码相同",0);

//            return Result.failure("与原密码相同");
        }

        return ResultUtil.success(0);
    }

    @GetMapping("/my-account")
    public String myAccount(HttpServletRequest request,Model model) {
//        User user = mUserService.findUserByName(userName);
        return "my-account";
    }


}
