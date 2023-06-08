package com.xueyin.productserver.service;

import com.xueyin.productserver.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductService {
    Product get(Long pid);
}
