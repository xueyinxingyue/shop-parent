package com.xueyin.orderserver.feign;

import com.xueyin.productserver.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")      //name:服务的名称
public interface ProductFenginApi {
    @Autowired

    //定义与远程调用服务的一致的方法
    @GetMapping("get/{id}")
    public Product get(@PathVariable Long id);
}
