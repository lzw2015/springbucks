package com.st.learning.springbucks.jpa.service;

import com.st.learning.springbucks.jpa.model.Coffee;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/10/14 上午10:26
 */
public interface OperationLogService {

    void trackMethod(Coffee coffee);

}
