package com.xueyin.productserver.service;

import com.xueyin.productserver.domain.Product;

public interface IProductService {
    Product get(Long pid);
}
