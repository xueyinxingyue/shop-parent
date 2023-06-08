package com.xueyin.orderserver.service;

public interface IOrderService {
    /**
     * 保存订单
     * @param userId    订单所属的用户id
     * @param pid       订单中商品的id
     */
    void save(Long userId,Long pid);
}
