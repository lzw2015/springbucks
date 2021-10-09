package com.st.learning.springbucks.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/10/9 上午10:08
 */
@Document
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {
    private static final long serialVersionUID = 5117905367102657682L;

    @Id
    private String id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;

}
