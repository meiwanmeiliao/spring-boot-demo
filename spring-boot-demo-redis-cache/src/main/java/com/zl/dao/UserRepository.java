package com.zl.dao;

import com.zl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/31
 * @description:
 **/
public interface UserRepository extends JpaRepository<User, Long> {
}
