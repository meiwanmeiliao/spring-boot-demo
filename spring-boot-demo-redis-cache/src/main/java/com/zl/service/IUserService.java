package com.zl.service;

import com.zl.entity.User;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/31
 * @description:
 **/
public interface IUserService {
    User selectById(Long id);

    User updateById(User bean);

    String deleteById(Long id);
}
