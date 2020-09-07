package com.jk.ssm.service.impl;

import com.jk.ssm.dao.IUserDao;
import com.jk.ssm.domain.Role;
import com.jk.ssm.domain.UserInfo;
import com.jk.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor Mr.JK
 * @create 2020-05-02  15:13
 */


@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()== 0?false:true,true,true,true, getAuthority(userInfo.getRoles()));
        return user;
    }
    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles){
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return list;
    }

    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    public UserInfo findById(String id) throws Exception {

        return  userDao.findById(id);
    }

    public List<Role> findOtherRoles(String userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }

    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds){
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
