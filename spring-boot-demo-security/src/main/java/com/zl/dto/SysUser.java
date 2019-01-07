package com.zl.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhuolin
 * @program: spring-boot-demo
 * @date 2019/1/7
 * @description: ${description}
 **/
public class SysUser implements UserDetails {

    private String username;

    private String password;

    private List<SysRole> sysRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        List<GrantedAuthority> auths = new ArrayList<>();
        List<SysRole> roles = this.getSysRoles();
        for (SysRole role : roles) {
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public boolean isAccountNonExpired () {
        return true;
    }

    @Override
    public boolean isAccountNonLocked () {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override
    public boolean isEnabled () {
        return true;
    }



    @Override
    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    @Override
    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public List<SysRole> getSysRoles () {
        return sysRoles;
    }

    public void setSysRoles (List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }
}
