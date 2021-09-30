package com.st.learning.springbucks.mybatis.mapper;

import com.st.learning.springbucks.mybatis.model.Coffee;
import com.st.learning.springbucks.mybatis.model.CoffeeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CoffeeMapper {
    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);

    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);
}