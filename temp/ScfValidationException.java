package com.st.learning.springbucks.jpa;

/**
 * @author lizhiwei
 * @since
 */
public class ScfValidationException extends RuntimeException {

    private ScfValidationErrors errors;

    public ScfValidationException(ScfValidationErrors errors) {
        this.errors = errors;
    }

    public ScfValidationErrors getErrors() {
        return errors;
    }
}
