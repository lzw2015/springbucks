package com.st.learning.springbucks.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizhiwei
 * @since
 */
@Configuration
public class ScfValidationConfig {

    @Bean
    public ScfMethodValidationPostProcessor scfMethodValidationPostProcessor(ScfValidatorExecutor scfValidatorExecutor) {
        ScfMethodValidationPostProcessor postProcessor = new ScfMethodValidationPostProcessor();
        postProcessor.setExecutor(scfValidatorExecutor);
        return postProcessor;
    }

}
