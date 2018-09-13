package com.zl.controller;

import com.zl.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @AUTH zhuolin
 * @DATE 2018/8/21
 * @description:
 **/
@RestController
@RequestMapping(value = "/mongodb")
public class MongodbController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value = "/insert")
    public Boolean insert() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(UUID.randomUUID().toString());
        user.setAge(20);
        mongoTemplate.insert(user);
        return true;
    }

    @RequestMapping(value = "/delete")
    public Boolean delete(String id) {
        Criteria criteria = Criteria.where("id").in(id);
        mongoTemplate.remove(new Query(criteria), User.class);
        return true;
    }

    @RequestMapping(value = "/update")
    public Boolean update(String id) {
        Update update = new Update();
        update.set("name", UUID.randomUUID().toString());
        update.set("age", 25);
        Query query = new Query(Criteria.where("id").in(id));
        mongoTemplate.updateMulti(query, update, User.class);
        return true;
    }

    @RequestMapping(value = "/select")
    public String select(String id) {
        Criteria criteria = Criteria.where("id").in(id);
        return mongoTemplate.findOne(new Query(criteria), User.class).toString();
    }


}
