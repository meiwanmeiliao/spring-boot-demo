package com.zl.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/12
 * @description:
 **/
//@Api(description = "api接口", tags = "apiXX")
@RestController
@RequestMapping(value = "/api")
public class WebController {

    @ApiOperation(value = "接口详细11", tags = {"接口详情1", "接口详情2"}, notes = "注意问题点")
    @GetMapping(value = "index")
    public String index(String value) {
        return value;
    }

    @ApiOperation(value = "接口详细12", tags = {"接口详情1"}, notes = "注意问题点2")
    @GetMapping(value = "index1")
    public User index1() {
        User user = new User();
        user.setAge(22);
        user.setName("张三");
        user.setSex("男");
        return user;
    }

    @ApiOperation(value = "接口详细14", tags = {"接口详情1"}, notes = "注意问题点4")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name" ,value = "用户名",dataType = "string",paramType = "query",example = "xiaoguo"),
            @ApiImplicitParam(name = "age",value = "年龄",dataType = "integer" ,paramType = "query",example = "20"),
            @ApiImplicitParam(name = "sex",value = "性别",dataType = "string" ,paramType = "query",example = "男")
    })
    @GetMapping(value = "index2")
    public User index2(String name,Integer age,String sex) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setSex(sex);
        return user;
    }

    @ApiOperation(value = "接口详细13", tags = {"接口详情1"}, notes = "注意问题点3")
    @PostMapping("/updateUserInfo")
    public User updateUserInfo(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) User user){
        return user;
    }

    @ApiModel(value = "用户对象", description = "用户详情")
    public static class User implements Serializable {
        @ApiModelProperty(value = "用户名", name = "name", example = "xingguo")
        String name;
        @ApiModelProperty(value = "年龄", name = "age", example = "20")
        Integer age;
        @ApiModelProperty(value = "性别", name = "sex", example = "男")
        String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
