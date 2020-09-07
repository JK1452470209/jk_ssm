package com.jk.ssm.dao;

import com.jk.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-01  12:28
 */

public interface IProductDao {

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    Product findById(Integer id);


    //查询所有产品信息
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
