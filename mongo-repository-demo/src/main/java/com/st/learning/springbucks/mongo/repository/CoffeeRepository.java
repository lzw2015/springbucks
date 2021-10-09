package com.st.learning.springbucks.mongo.repository;

import com.st.learning.springbucks.mongo.model.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/10/9 上午10:33
 */
public interface CoffeeRepository extends MongoRepository<Coffee, String> {

    List<Coffee> findByName(String name);

}
