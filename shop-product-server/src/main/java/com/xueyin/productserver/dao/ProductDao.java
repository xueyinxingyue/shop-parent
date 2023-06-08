package com.xueyin.productserver.dao;

import com.xueyin.productserver.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Long> {
}
