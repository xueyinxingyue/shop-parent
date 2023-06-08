package com.xueyin.orderserver.controller;

import com.xueyin.orderserver.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
