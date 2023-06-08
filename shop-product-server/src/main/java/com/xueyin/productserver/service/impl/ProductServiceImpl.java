package com.xueyin.productserver.service.impl;

import com.xueyin.productserver.dao.ProductDao;
import com.xueyin.productserver.domain.Product;
import com.xueyin.productserver.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product get(Long pid) {
        Product product = productDao.findById(pid).get();
        return product;
    }
}
