package com.zl.service.impl;

import com.zl.dao.UserRepository;
import com.zl.entity.User;
import com.zl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/31
 * @description:
 **/
@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Cacheable(cacheNames = "user",key = "#p0")
    @Override
    public User selectById(Long id) {
        System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
        return userRepository.findOne(id);
    }

    @CachePut(key = "#p0.id")
    @Override
    public User updateById(User bean) {
        System.out.println("更新功能，更新缓存，直接写库, id=" + bean);
        return userRepository.save(bean);
    }

    @CacheEvict(key = "#p0")
    @Override
    public String deleteById(Long id) {
        System.out.println("删除功能，删除缓存，直接写库, id=" + id);
        userRepository.delete(id);
        return "清空缓存成功";
    }
}
