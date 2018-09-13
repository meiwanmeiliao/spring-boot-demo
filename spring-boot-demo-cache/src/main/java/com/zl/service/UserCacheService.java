package com.zl.service;


import com.zl.entity.User;

/**
 * @author wujing
 */
public interface UserCacheService {

    /**
     * 查询
     *
     * @param id
     * @return
     */
    User selectById(Long id);

    /**
     * 更新
     *
     * @param user
     * @return
     */
    User updateById(User user);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    String deleteById(Long id);
}
