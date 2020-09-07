package com.jk.ssm.service.impl;

import com.jk.ssm.dao.ISysLogDao;
import com.jk.ssm.domain.SysLog;
import com.jk.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-05  10:13
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;


    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
