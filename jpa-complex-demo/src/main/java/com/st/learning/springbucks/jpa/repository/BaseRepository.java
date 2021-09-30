package com.st.learning.springbucks.jpa.repository;

import com.st.learning.springbucks.jpa.model.CoffeeOrder;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/30 上午8:37
 */
@NoRepositoryBean
public interface BaseRepository<T, ID> extends PagingAndSortingRepository<T, ID> {

    List<CoffeeOrder> findTop3ByOrderByUpdateTimeDescIdAsc();

}
