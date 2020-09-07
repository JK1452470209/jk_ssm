package com.jk.ssm.service;

import com.jk.ssm.domain.Permission;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-04  9:54
 */
public interface IPermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
