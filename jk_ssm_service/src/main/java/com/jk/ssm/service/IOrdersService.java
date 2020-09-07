package com.jk.ssm.service;

import com.jk.ssm.domain.Orders;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-01  16:30
 */
public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
