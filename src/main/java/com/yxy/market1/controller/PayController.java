//package com.yxy.market1.controller;
//
//import com.yxy.market1.contrller.base.BaseController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Map;
//
//public class PayController extends BaseController {
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private PayService payService;
//
//    @GetMapping("/pay")
//    public ModelAndView index(@RequestParam("openid") String openid,
//                              @RequestParam("orderId") String orderId,
//                              @RequestParam("returnUrl") String returnUrl,
//                              Map<String,Object> map){
////        log.info("openid={}",openid);
//        //1.查询订单
////        String orderId="1234563";
//        OrderDTO orderDTO=orderService.findOne(orderId);
//        if(orderDTO==null){
//            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
//        }
//        //2.发起支付
//        orderDTO.setBuyerOpenid(openid);
//        PayResponse payResponse=payService.create(orderDTO);
//
//        map.put("payResponse",payResponse);
//        map.put("returnUrl","http://www.imooc.com");
//
//        return new ModelAndView("pay/create",map);
//    }
//
//    @GetMapping("/create")
//    public ModelAndView create(@RequestParam("orderId") String orderId,
//                               @RequestParam("returnUrl") String returnUrl,
//                               Map<String,Object> map){
//        //1.查询订单
//        OrderDTO orderDTO=orderService.findOne(orderId);
//        if(orderDTO==null){
//            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
//        }
//        //2.发起支付
//        PayResponse payResponse=payService.create(orderDTO);
//
//        map.put("payResponse",payResponse);
//        map.put("returnUrl",returnUrl);
//
//        return new ModelAndView("pay/create",map);
//    }
//}
