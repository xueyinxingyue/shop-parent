package com.xueyin.orderserver.service.impl;

import com.xueyin.orderserver.dao.OrderDao;
import com.xueyin.orderserver.domain.Order;
import com.xueyin.orderserver.service.IOrderService;
import com.xueyin.productserver.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements IOrderService {
    //注入远程调用的对象
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Long userId, Long pid) {
        Order order = new Order();
        order.setUid(userId);
        order.setPname("xueyin");

        //设置商品信息    根据商品id查询商品信息
        //远程调用商品服务接口获取商品信息
        Product product = restTemplate.getForObject("http://localhost:8081/get/" + pid, Product.class);
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());

        order.setNumber(100);

        orderDao.save(order);
    }
}
