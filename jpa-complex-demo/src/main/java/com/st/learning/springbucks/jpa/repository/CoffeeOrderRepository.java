package com.st.learning.springbucks.jpa.repository;

import com.st.learning.springbucks.jpa.model.CoffeeOrder;

import java.util.List;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/30 上午8:39
 */
public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {
    List<CoffeeOrder> findByCustomerOrderById(String customer);

    List<CoffeeOrder> findByItems_Name(String name);
}
