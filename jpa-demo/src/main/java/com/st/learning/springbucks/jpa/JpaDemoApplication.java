package com.st.learning.springbucks.jpa;

import com.bj58.fangchan.sydc.cms.log.core.annotation.OperationLogScan;
import com.st.learning.springbucks.jpa.model.Coffee;
import com.st.learning.springbucks.jpa.model.CoffeeOrder;
import com.st.learning.springbucks.jpa.repository.CoffeeOrderRepository;
import com.st.learning.springbucks.jpa.repository.CoffeeRepository;
import com.st.learning.springbucks.jpa.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@EnableJpaRepositories
@SpringBootApplication
@OperationLogScan(basePackages = "com.st.learning.springbucks.jpa")
public class JpaDemoApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeOrderRepository orderRepository;

    @Autowired
    private OperationLogService operationLogService;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Coffee coffee = new Coffee();
        coffee.setId(1L);
        coffee.setName("卡布奇诺");

        operationLogService.trackMethod(coffee);

        //initOrders();

    }

    private void initOrders() {
        Coffee espresso = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeRepository.save(espresso);
        log.info("Coffee: {}", espresso);

        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeRepository.save(latte);
        log.info("Coffee: {}", latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Collections.singletonList(espresso))
                .state(0)
                .build();
        orderRepository.save(order);
        log.info("Order: {}", order);

        order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Arrays.asList(espresso, latte))
                .state(0)
                .build();
        orderRepository.save(order);
        log.info("Order: {}", order);
    }
}
