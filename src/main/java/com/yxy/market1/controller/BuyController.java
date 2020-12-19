package com.yxy.market1.controller;

import com.yxy.market1.Utils.ResultUtil;
import com.yxy.market1.controller.base.BaseController;
import com.yxy.market1.entity.Notice;
import com.yxy.market1.entity.Order;
import com.yxy.market1.entity.Product;
import com.yxy.market1.entity.User;
import com.yxy.market1.entity.dto.response.Result;
import com.yxy.market1.entity.dto.response.SellerResponse;
import com.yxy.market1.service.INoticeService;
import com.yxy.market1.service.IOrderService;
import com.yxy.market1.service.IProductService;
import com.yxy.market1.service.IUserService;
import com.yxy.market1.service.impl.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class BuyController extends BaseController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IProductService productService;
    @Autowired
    private INoticeService noticeService;
    @Autowired
    private IOrderService orderService;

    @PostMapping("/getseller")
    @ResponseBody
    public Result<SellerResponse> getSellerId(HttpServletRequest request, Integer productId) {
        User user;
        Integer sellerId = productService.findSellerIdById(productId);
        Optional<User> userById = userService.findUserById(sellerId);
        if (userById.isPresent()) {
            user = userById.get();
        } else {
            return ResultUtil.fail("there is no such seller");
        }
        SellerResponse response = new SellerResponse(user.getPhone(), user.getAddress(), user.getUserId());
        return ResultUtil.success(response);
    }

    @PostMapping("/buyproduct")
    @ResponseBody
    public Result<Integer> buyProduct(HttpServletRequest request, Integer productId, Integer buyerId) {
        System.out.println(buyerId);
        System.out.println(productId);
        User u = userService.findUserById(buyerId).get();
        Product p = productService.findProductById(productId);
        Double money = p.getPrice();
        if (money > u.getMoney()) {
            return ResultUtil.fail("你没有这么多钱，哭哭");
        }
        if (p.getStatus().equals("已售出")) {
            return ResultUtil.fail("商品卖完了");
        }
        p.setStatus("已售出");
        u.setMoney(u.getMoney() - money);
        productService.createProduct(p);
        userService.insertUser(u);
        Date date = new Date();
        Notice notice = new Notice(u.getUserId(), date, "购买了商品" + p.getName());
        Notice notice1 = new Notice(p.getSellerid(), date, "您的商品" + p.getName() + "已被用户" + u.getUsername() + "购买");
        noticeService.addNotice(notice);
        noticeService.addNotice(notice1);
        Order order = new Order();
        order.setBuyerId(u.getUserId());
        order.setSellerId(p.getSellerid());
        order.setStatus("未完成");
//        order.setSellerId(p.getSellerid());
        orderService.createOrder(order);
        return ResultUtil.success(0);
    }

    @PostMapping("/endorder")
    @ResponseBody
    public Result<Integer> endOrder(HttpServletRequest request, Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        Integer buyerId = order.getBuyerId();
        Integer sellerId = order.getSellerId();
        order.setStatus("已完成");
        User user = userService.findUserById(sellerId).get();
        Product p = productService.findProductById(order.getProductId());
        user.setMoney(user.getMoney() + p.getPrice());
        userService.insertUser(user);
        Date date = new Date();
        Notice notice = new Notice(buyerId, date, "已确认收货并完成订单");
        Notice notice1 = new Notice(sellerId, date, "产品" + p.getName() + "由" + user.getUsername() + "确认收货,你的账户收到" + p.getPrice() + "元");
        orderService.createOrder(order);
        noticeService.addNotice(notice);
        noticeService.addNotice(notice1);
        return ResultUtil.success(0);
    }

    @PostMapping("/get-notice")
    @ResponseBody
    public Result<List<Notice>> getNotice(HttpServletRequest request, Integer userid) {
        return ResultUtil.success(noticeService.getNoticeByUserId(userid));
    }
}
