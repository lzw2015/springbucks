package com.st.learning.springbucks.jedis.model;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/30 上午8:30
 */
@Entity
@Table(name = "T_COFFEE")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee extends BaseEntity {
    private static final long serialVersionUID = -1355377069484442112L;

    private String name;
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;

}
