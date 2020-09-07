package com.jk.ssm.dao;

import com.jk.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @outhor Mr.JK
 * @create 2020-05-02  11:47
 */

public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;

}
