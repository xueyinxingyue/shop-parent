package com.xueyin.orderserver.controller;

import com.xueyin.orderserver.domain.Order;
import com.xueyin.orderserver.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("save")
    public String save(Long uid,Long pid){
        orderService.save(uid, pid);
        return "success";
    }

    //需求：根据id查询订单信息，同时查询订单包含的商品信息
    @GetMapping("get/{id}")
    public Order get(@PathVariable Long id){
        //调用service查询订单信息
        Order order = orderService.getById(id);
        return order;
    }
}
