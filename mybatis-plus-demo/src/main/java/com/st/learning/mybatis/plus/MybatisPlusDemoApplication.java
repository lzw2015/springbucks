package com.st.learning.mybatis.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.st.learning.mybatis.plus.mapper.CoffeeMapper;
import com.st.learning.mybatis.plus.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan("com.st.learning.mybatis.plus.mapper")
@SpringBootApplication
public class MybatisPlusDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        QueryWrapper<Coffee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "espresso");

        Coffee coffee = coffeeMapper.selectOne(queryWrapper);

        log.debug("coffee {}", coffee);


    }
}
