package com.st.learning.springbucks.mybatis.mapper;

import com.st.learning.springbucks.mybatis.model.Coffee;
import org.apache.ibatis.annotations.*;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/30 上午9:24
 */
@Mapper
public interface CoffeeMapper {

    @Insert("insert into t_coffee (name, price, create_time, update_time)"
            + "values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Coffee coffee);

    @Select("select * from t_coffee where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime"),
            // map-underscore-to-camel-case = true 可以实现一样的效果
            // @Result(column = "update_time", property = "updateTime"),
    })
    Coffee findById(@Param("id") Long id);

}
