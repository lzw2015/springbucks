package com.st.learning.springbucks.jedis.repository;

import com.st.learning.springbucks.jedis.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/23 下午4:57
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
