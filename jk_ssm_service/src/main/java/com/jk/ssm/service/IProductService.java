package com.jk.ssm.service;


import com.jk.ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-01  12:30
 */
@Service
public interface IProductService {

    List<Product> findAll() throws Exception;

    List<Product> findAllPage(int page,int size) throws Exception;

    void save(Product product) throws Exception;
}
