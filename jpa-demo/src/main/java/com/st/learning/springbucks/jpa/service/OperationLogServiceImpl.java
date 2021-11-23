package com.st.learning.springbucks.jpa.service;

import com.bj58.fangchan.sydc.cms.log.core.annotation.OperationLog;
import com.bj58.fangchan.sydc.cms.log.core.annotation.TrackOperationLog;
import com.bj58.fangchan.sydc.cms.log.core.enums.OperationTypeEnum;
import com.st.learning.springbucks.jpa.model.Coffee;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author lizhiwei
 * @Date 2021/10/14 上午10:26
 */
@Service
@OperationLog(businessType = "测试业务", businessModule = "日志管理")
public class OperationLogServiceImpl implements OperationLogService {

    @Override
    @TrackOperationLog(operationType = OperationTypeEnum.QUERY, messageCode = "test", argParseRules = "coffee.name")
    public void trackMethod(Coffee coffee) {

        System.out.println(coffee.getId());

    }
}
