package com.st.learning.springbucks.jpa;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lizhiwei
 * @since
 */
public class ScfValidationErrors {

    private Map<String, String> errors = new LinkedHashMap<>();

    public void rejectValue(String field, String message) {
        errors.put(field, message);
    }

    public boolean hasError() {
        return !errors.isEmpty();
    }

}
