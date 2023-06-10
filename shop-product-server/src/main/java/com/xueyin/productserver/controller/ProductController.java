package com.xueyin.productserver.controller;

import com.xueyin.productserver.domain.Product;
import com.xueyin.productserver.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @Value("${server.port}")
    private String port;

    //根据id查询商品请求
    @GetMapping("get/{pid}")
    public Product get(@PathVariable Long pid){
        Product product = productService.get(pid);
        product.setPname(product.getPname() + " from " + port);
        return product;
    }
}
