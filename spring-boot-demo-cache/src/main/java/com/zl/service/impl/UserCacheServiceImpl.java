package com.zl.service.impl;

import com.zl.dao.UserRepository;
import com.zl.entity.User;
import com.zl.service.UserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
/**
 * @author zhuolin
 */
@CacheConfig(cacheNames = "user")
@Service
public class UserCacheServiceImpl implements UserCacheService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(key = "#p0")
    @Override
    public User selectById(Long id) {
        System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
        return userRepository.findOne(id);
    }

    @CachePut(key = "#p0")
    @Override
    public User updateById(User roncooUserLog) {
        System.out.println("更新功能，更新缓存，直接写库, id=" + roncooUserLog);
        return userRepository.save(roncooUserLog);
    }

    @CacheEvict(key = "#p0")
    @Override
    public String deleteById(Long id) {
        System.out.println("删除功能，删除缓存，直接写库, id=" + id);
        return "清空缓存成功";
    }

}
