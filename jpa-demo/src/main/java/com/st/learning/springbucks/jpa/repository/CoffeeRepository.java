package com.st.learning.springbucks.jpa.repository;

import com.st.learning.springbucks.jpa.model.Coffee;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/23 下午4:56
 */
public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
