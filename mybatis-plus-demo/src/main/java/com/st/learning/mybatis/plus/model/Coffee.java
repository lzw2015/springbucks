package com.st.learning.mybatis.plus.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@TableName("t_coffee")
public class Coffee implements Serializable {
    private static final long serialVersionUID = -4329380634601253259L;

    private Long id;
    private String name;
    private Long price;
    private Date createTime;
    private Date updateTime;

}
