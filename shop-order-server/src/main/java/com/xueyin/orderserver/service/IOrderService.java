package com.xueyin.orderserver.service;

import com.xueyin.orderserver.domain.Order;

public interface IOrderService {
    /**
     * 保存订单
     * @param userId    订单所属的用户id
     * @param pid       订单中商品的id
     */
    void save(Long userId,Long pid);

    Order getById(Long id);
}
