package com.xueyin.orderserver.domain;

import com.xueyin.productserver.domain.Product;
import lombok.Data;

import javax.persistence.*;

//订单
@Entity(name = "t_shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;//订单id
    //用户
    private Long uid;//用户id
    private String username;//用户名
    //商品
    private Long pid;//商品id
    private String pname;//商品名称
    private Double pprice;//商品单价
    //数量
    private Integer number;//购买数量

    //包含商品信息
    @Transient
    private Product product;
}
