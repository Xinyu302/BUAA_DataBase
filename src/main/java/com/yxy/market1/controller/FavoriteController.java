package com.yxy.market1.controller;

import com.yxy.market1.Utils.ResultUtil;
import com.yxy.market1.controller.base.BaseController;
import com.yxy.market1.entity.Favorite;
import com.yxy.market1.entity.dto.form.FavoriteForm;
import com.yxy.market1.entity.dto.response.Result;
import com.yxy.market1.service.IFavoriteService;
import com.yxy.market1.service.impl.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FavoriteController extends BaseController {
    @Autowired
    private IFavoriteService fService;

    @PostMapping("add-to-cart")
    @ResponseBody
    public Result<Integer> addFavorite(HttpServletRequest request, FavoriteForm favoriteForm) {
        if (fService.findFavoriteByUserIdAndProductId(favoriteForm.getUserId(), favoriteForm.getProductId()) != null) {
            return ResultUtil.fail("已经在购物车中");
        }
        Favorite favorite = new Favorite();
        favorite.setProductId(favoriteForm.getProductId());
        favorite.setUserId(favoriteForm.getUserId());
        fService.createFavorite(favorite);
        return ResultUtil.success(0);
    }
}
