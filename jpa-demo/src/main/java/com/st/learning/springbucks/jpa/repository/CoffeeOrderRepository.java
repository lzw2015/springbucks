package com.st.learning.springbucks.jpa.repository;

import com.st.learning.springbucks.jpa.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/23 下午4:57
 */
public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}
