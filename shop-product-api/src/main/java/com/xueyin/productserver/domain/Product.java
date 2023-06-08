package com.xueyin.productserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//商品

//实体类对应的表名
@Entity(name = "t_shop_product")
@Data
public class Product {
    //对应表中属性
    @Id
    //主键生成的方式
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;//主键
    private String pname;//商品名称
    private Double pprice;//商品价格
    private Integer stock;//库存
}