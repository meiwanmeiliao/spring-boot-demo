package com.zl.service;

import com.zl.dto.SysRole;
import com.zl.dto.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuolin
 * @program: spring-boot-demo
 * @date 2019/1/7
 * @description: ${description}
 **/
public class CustomerUserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        if (username == null || !"admin".equals(username)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword("123456");
        List<SysRole> roles = new ArrayList<>();
        SysRole sysRole = new SysRole();
        sysRole.setName("ROLE_ADMIN");
        roles.add(sysRole);
        sysUser.setSysRoles(roles);
        return sysUser;
    }
}
