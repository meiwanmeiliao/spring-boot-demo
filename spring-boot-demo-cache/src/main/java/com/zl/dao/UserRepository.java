package com.zl.dao;

import com.zl.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/21
 * @description:
 **/
public interface UserRepository extends JpaRepository<User, Long> {

}
