package com.xueyin.orderserver.dao;

import com.xueyin.orderserver.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {
}
