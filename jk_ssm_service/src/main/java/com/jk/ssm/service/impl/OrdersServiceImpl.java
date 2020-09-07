package com.jk.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.ssm.dao.IOrdersDao;
import com.jk.ssm.domain.Orders;
import com.jk.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-01  16:32
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    public List<Orders> findAll(int page,int size) throws Exception {

        //参数pageNum是页码值，参数pageSize代表是每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
