package com.jk.ssm.service;

import com.jk.ssm.domain.SysLog;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-05  10:13
 */
public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws  Exception;
}
