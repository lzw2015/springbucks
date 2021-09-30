package com.st.learning.springbucks.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/9/30 上午9:22
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {
    private static final long serialVersionUID = -4329380634601253259L;

    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;

}
