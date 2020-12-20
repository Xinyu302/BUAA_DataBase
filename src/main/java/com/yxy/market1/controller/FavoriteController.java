package com.yxy.market1.controller;

import com.yxy.market1.Utils.ResultUtil;
import com.yxy.market1.controller.base.BaseController;
import com.yxy.market1.entity.Favorite;
import com.yxy.market1.entity.Product;
import com.yxy.market1.entity.dto.form.FavoriteForm;
import com.yxy.market1.entity.dto.response.ProductResponse;
import com.yxy.market1.entity.dto.response.Result;
import com.yxy.market1.service.IFavoriteService;
import com.yxy.market1.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FavoriteController extends BaseController {
    @Autowired
    private IFavoriteService fService;

    @Autowired
    private IProductService pService;

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

    @PostMapping("get-cart")
    @ResponseBody
    public Result<List<ProductResponse>> getFavorites(HttpServletRequest request, Integer userId) {
        System.out.println(userId);
        List<Integer> product = fService.findProductIdByUserId(userId);
        System.out.println(product);
        List<Product> products = pService.findProductByIdIn(product);
        System.out.println(products);
        List<ProductResponse> responces = new ArrayList<>();
        for (Product p : products) {
            responces.add(new ProductResponse(p.getId(), p.getName(), p.getPrice(), p.getPictureAddr()));
        }
        return ResultUtil.success(responces);
    }

    @PostMapping("delete-all-cart")
    @ResponseBody
    public Result<Integer> deleteAllFavorites(HttpServletRequest request,Integer userId) {
        fService.deleteAllProductsByUserId(userId);
        return ResultUtil.success(0);
    }

    @PostMapping("delete-one-cart")
    @ResponseBody
    public Result<Integer> deleteOneFavorite(HttpServletRequest request,FavoriteForm form) {
        fService.deleteProductByUserIdAndProductId(form.getUserId(), form.getProductId());
        return ResultUtil.success(0);
    }
}
