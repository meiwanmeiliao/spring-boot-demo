package com.zl.mappper;

import com.zl.model.UserModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/13
 * @description:
 **/
@Mapper
public interface UserMapper {

    @Insert(value = "insert into user (name,create_time) values(#{name,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP})")
    public int insert(UserModel userModel);

    @Select(value = "select id ,name,create_time from user where id = #{id,jdbcType=BIGINT}")
    @Results(value = {@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP)})
    public UserModel selectById(Long id);

}
