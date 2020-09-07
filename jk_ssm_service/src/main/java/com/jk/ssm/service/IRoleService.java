package com.jk.ssm.service;

import com.jk.ssm.domain.Permission;
import com.jk.ssm.domain.Role;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-04  9:33
 */
public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
