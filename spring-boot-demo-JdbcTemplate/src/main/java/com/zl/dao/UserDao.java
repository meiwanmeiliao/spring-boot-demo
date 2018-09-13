package com.zl.dao;

import com.zl.base.Page;
import com.zl.bean.User;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/2
 * @description:
 **/
public interface UserDao {

    int insert(User user);

    int deleteById(Long id);

    int updateById(User user);

    User selectById(Long id);

    Page<User> queryForPage(int pageNo, int pageSize);

}
