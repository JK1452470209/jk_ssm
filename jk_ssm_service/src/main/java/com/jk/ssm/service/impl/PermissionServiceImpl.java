package com.jk.ssm.service.impl;

import com.jk.ssm.dao.IPermissionDao;
import com.jk.ssm.domain.Permission;
import com.jk.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-04  9:54
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
