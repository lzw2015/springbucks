package com.st.learning.springbucks.jedis.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/30 上午8:32
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "T_ORDER")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder extends BaseEntity {
    private static final long serialVersionUID = -3153227918902052205L;

    private String customer;

    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")
    private List<Coffee> items;

    @Enumerated
    @Column(nullable = false)
    private OrderState state;

}
