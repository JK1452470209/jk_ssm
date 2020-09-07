package com.jk.ssm.service;

import com.jk.ssm.domain.Product;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-01  12:30
 */
public interface IProductService {

    List<Product> findAll() throws Exception;


    void save(Product product) throws Exception;
}
