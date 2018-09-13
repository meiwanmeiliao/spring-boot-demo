package com.zl.dao;

import com.zl.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/20
 * @description:
 **/
public interface UserDao extends JpaRepository<User, Long> {
}
