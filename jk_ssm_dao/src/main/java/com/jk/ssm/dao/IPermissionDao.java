package com.jk.ssm.dao;

import com.jk.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-03  21:17
 */
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findPermissionByRoleId(String id) throws Exception;


    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
