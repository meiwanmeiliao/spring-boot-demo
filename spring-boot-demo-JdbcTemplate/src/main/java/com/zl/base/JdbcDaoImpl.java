package com.zl.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/2
 * @description:
 **/
public abstract class JdbcDaoImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 获取当前食物最后一次更新的主键值
     *
     * @return
     */
    public Long getLastId() {
        return jdbcTemplate.queryForObject("select last_insert_id() as id ", Long.class);
    }

    /**
     * 获取对象信息
     *
     * @param sql
     * @param clazz
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForObject(String sql, Class<T> clazz, Object... args) {
        Assert.hasText(sql, "sql语句不能为空");
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(clazz), args);
    }

    /**
     * 获取对象集合信息
     *
     * @param sql
     * @param clazz
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForObjectList(String sql, Class<T> clazz, Object... args) {
        Assert.hasText(sql, "sql语句不能为空");
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(clazz), args);
    }

    /**
     * 分页查询
     *
     * @param sql
     * @param currentPage
     * @param pageSize
     * @param args
     * @return
     */
    public Page<Map<String, Object>> queryForPage(String sql, int currentPage, int pageSize, Object... args) {
        Assert.hasText(sql, "sql 语句不能为空");
        Assert.isTrue(currentPage >= 1, "pageNo 必须大于等于1");
        String sqlCount = Sql.countSql(sql);
        int count = jdbcTemplate.queryForObject(sqlCount, Integer.class, args);
        currentPage = Sql.checkPageCurrent(count, pageSize, currentPage);
        pageSize = Sql.checkPageSize(pageSize);
        int totalPage = Sql.countTotalPage(count, pageSize);
        String sqlList = sql + Sql.limitSql(count, currentPage, pageSize);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlList, args);
        return new Page<Map<String, Object>>(list, count, totalPage, currentPage, pageSize);
    }

    /**
     * 分页
     *
     * @param sql
     * @param currentPage
     * @param pageSize
     * @param clazz
     * @param args
     * @param <T>
     * @return
     */
    public <T> Page<T> queryForPage(String sql, int currentPage, int pageSize, Class<T> clazz, Object... args) {
        Assert.hasText(sql, "sql 语句不能为空");
        Assert.isTrue(currentPage >= 1, "pageNo 必须大于等于1");
        Assert.isTrue(clazz != null, "clazz 不能为空");
        String sqlCount = Sql.countSql(sql);
        int count = jdbcTemplate.queryForObject(sqlCount, Integer.class, args);
        currentPage = Sql.checkPageCurrent(count, pageSize, currentPage);
        pageSize = Sql.checkPageSize(pageSize);
        int totalPage = Sql.countTotalPage(count, pageSize);
        String sqlList = sql + Sql.limitSql(count, currentPage, pageSize);
        List<T> list = jdbcTemplate.query(sqlList, new BeanPropertyRowMapper<T>(clazz), args);
        return new Page<T>(list, count, totalPage, currentPage, pageSize);
    }
}
