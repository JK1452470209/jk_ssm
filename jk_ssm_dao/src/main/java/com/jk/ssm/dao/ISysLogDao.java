package com.jk.ssm.dao;

import com.jk.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-05  10:14
 */
public interface ISysLogDao {

    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;

    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;
}
