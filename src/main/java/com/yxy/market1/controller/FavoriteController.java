package com.yxy.market1.controller;

import com.yxy.market1.controller.base.BaseController;
import com.yxy.market1.service.IFavoriteService;
import com.yxy.market1.service.impl.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FavoriteController extends BaseController {
    @Autowired
    private IFavoriteService fService;



}
