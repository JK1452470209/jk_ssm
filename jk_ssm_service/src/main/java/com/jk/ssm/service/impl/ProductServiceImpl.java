package com.jk.ssm.service.impl;

import com.jk.ssm.dao.IProductDao;
import com.jk.ssm.domain.Product;
import com.jk.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-01  12:31
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public List<Product> findAll() throws Exception{
        return productDao.findAll();
    }

    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
