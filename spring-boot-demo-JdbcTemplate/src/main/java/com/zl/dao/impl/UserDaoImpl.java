package com.zl.dao.impl;

import com.zl.base.JdbcDaoImpl;
import com.zl.base.Page;
import com.zl.bean.User;
import com.zl.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/2
 * @description:
 **/
@Repository
public class UserDaoImpl extends JdbcDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        String sql = "insert into zl_user (name, create_time) values (?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getCreateTime());
    }

    @Override
    public int deleteById(Long id) {
        String sql = "delete from zl_user where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateById(User user) {
        String sql = "update zl_user set name=?, create_time=? where id=?";
        return jdbcTemplate.update(sql, user.getName(), user.getCreateTime(), user.getId());
    }

    @Override
    public User selectById(Long id) {
        String sql = "select * from zl_user where id=?";
        return queryForObject(sql, User.class, id);
    }

    @Override
    public Page<User> queryForPage(int pageNo, int pageSize) {
        StringBuffer sql = new StringBuffer("select * from zl_user where 1=1");
        return queryForPage(sql.toString(), pageNo, pageSize, User.class);
    }
}
