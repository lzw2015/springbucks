package com.st.learning.springbucks.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lizhiwei
 * @since
 */
@Component
public class MethodValidatorExecutor implements ScfValidatorExecutor {

    @Autowired
    private List<ScfValidator> validators;

    @Override
    public void validate(Object target, ScfValidationErrors errors) {
        validators.stream()
                .filter(scfValidator -> scfValidator.support(target.getClass()))
                .forEach(scfValidator -> scfValidator.validate(target, errors));
    }
}
