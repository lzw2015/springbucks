package com.st.learning.springbucks.jpa;

/**
 * @author lizhiwei
 * @since
 */
public interface ScfValidator {

    boolean support(Class<?> clazz);

    void validate(Object target, ScfValidationErrors errors);

}
