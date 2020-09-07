package com.jk.ssm.dao;

import com.jk.ssm.domain.Member;
import com.jk.ssm.domain.Orders;
import com.jk.ssm.domain.Product;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-01  16:33
 */

public interface IOrdersDao {


    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "payTypeStr",column = "payTypeStr"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,
                    one = @One(select = "com.jk.ssm.dao.IProductDao.findById"))
    })
    public List<Orders> findAll() throws Exception;


    //多表操作
    @Select("select * from orders where id = #{orderId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "payTypeStr",column = "payTypeStr"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,
                    one = @One(select = "com.jk.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,
                    one = @One(select = "com.jk.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "com.jk.ssm.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId) throws Exception;
}
