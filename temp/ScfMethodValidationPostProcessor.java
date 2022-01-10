package com.st.learning.springbucks.jpa;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.InitializingBean;

import java.lang.annotation.Annotation;

/**
 * @author lizhiwei
 * @since
 */
public class ScfMethodValidationPostProcessor extends AbstractBeanFactoryAwareAdvisingPostProcessor
        implements InitializingBean {

    private Class<? extends Annotation> validatedAnnotationType = ScfValidated.class;

    private ScfValidatorExecutor executor;

    public void setExecutor(ScfValidatorExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Pointcut pointcut = new AnnotationMatchingPointcut(this.validatedAnnotationType, true);
        this.advisor = new DefaultPointcutAdvisor(pointcut, createMethodValidationAdvice(this.executor));
    }

    private Advice createMethodValidationAdvice(ScfValidatorExecutor executor) {
        return new ScfMethodValidationInterceptor(executor);
    }
}
