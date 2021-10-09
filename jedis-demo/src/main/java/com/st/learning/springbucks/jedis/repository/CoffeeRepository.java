package com.st.learning.springbucks.jedis.repository;

import com.st.learning.springbucks.jedis.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/23 下午4:56
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
