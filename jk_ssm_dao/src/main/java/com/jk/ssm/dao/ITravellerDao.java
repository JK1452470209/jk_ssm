package com.jk.ssm.dao;

import com.jk.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-02  11:50
 */

public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;

}
