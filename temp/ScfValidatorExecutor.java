package com.st.learning.springbucks.jpa;

/**
 * @author lizhiwei
 * @since
 */
public interface ScfValidatorExecutor {

    void validate(Object target, ScfValidationErrors errors);

}
