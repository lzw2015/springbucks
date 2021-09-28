package com.st.learning.springbucks.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.money.Money;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/23 下午4:40
 */
@Entity
@Table(name = "T_MENU")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coffee implements Serializable {
    private static final long serialVersionUID = 4114285721259952319L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmount", parameters = {
            @org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")
    })
    private Money price;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

}
