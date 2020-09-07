package com.jk.ssm.service.impl;

import com.jk.ssm.dao.IRoleDao;
import com.jk.ssm.domain.Permission;
import com.jk.ssm.domain.Role;
import com.jk.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-04  9:34
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {


    @Autowired
    private IRoleDao roleDao;

    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionid : permissionIds){
            roleDao.addPermissionToRole(roleId,permissionid);
        }
    }
}
