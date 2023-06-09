package com.xueyin.orderserver.service.impl;

import com.xueyin.orderserver.dao.OrderDao;
import com.xueyin.orderserver.domain.Order;
import com.xueyin.orderserver.feign.ProductFenginApi;
import com.xueyin.orderserver.service.IOrderService;
import com.xueyin.productserver.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements IOrderService {
    //注入远程调用的对象
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductFenginApi productFenginApi;

    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Long userId, Long pid) {
        Order order = new Order();
        order.setUid(userId);
        order.setUsername("xueyin");

        //设置商品信息    根据商品id查询商品信息
        //远程调用商品服务接口获取商品信息
        Product product = restTemplate.getForObject("http://localhost:8081/get/" + pid, Product.class);
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());

        order.setNumber(100);

        orderDao.save(order);
    }

    @Override
    public Order getById(Long id) {
        //根据id查询订单信息    order
        Order order = orderDao.findById(id).get();

        //在根据订单中存储的pid查询商品的信息   product
        //远程商品微服务中根据商品id查询商品的接口
        //  http://localhost:8081/get/1     {"pid":1,"pname":"小米","pprice":1000.0,"stock":5000}
//        Product product = restTemplate.getForObject("http://localhost:8081/get/" + order.getPid(), Product.class);

//        //获取nacos中的服务
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("product-service");//参数为服务名称
//
//        //从instanceList获取某一个服务实例对象
//        ServiceInstance instance = instanceList.get(0);
//        //发起远程调用    远程调用商品微服务中根据商品id查询商品的接口
//        //拼接请求地址
//        String url = "http://" + instance.getHost() + ":" + instance.getPort();//http://localhost:8081
//        Product product = restTemplate.getForObject(url + "/get/" + order.getPid(), Product.class);

        /**
         * 手动实现负载均衡
         */
//        //获取nacos中的服务
//        List<ServiceInstance> instanceList = discoveryClient.getInstances("product-service");//参数为服务名称
//        //从随机的从instanceList获取一个服务实例对象
//        int index = new Random().nextInt(instanceList.size());
//        ServiceInstance instance = instanceList.get(index);
//
//        //发起远程调用    远程调用商品微服务中根据商品id查询商品的接口
//        //拼接请求地址
//        String url = "http://" + instance.getHost() + ":" + instance.getPort();//http://localhost:8081
//        Product product = restTemplate.getForObject(url + "/get/" + order.getPid(), Product.class);

        /**
         * 使用ribbon的负载均衡
         */
//        Product product = restTemplate.getForObject("http://product-service/get/" + order.getPid(), Product.class);

        //基于feign远程调用商品服务
        Product product = productFenginApi.get(order.getPid());

        //将product存放到order中
        order.setProduct(product);

        return order;
    }
}
