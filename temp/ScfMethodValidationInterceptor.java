package com.st.learning.springbucks.jpa;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * @author lizhiwei
 * @since
 */
public class ScfMethodValidationInterceptor implements MethodInterceptor {

    private final ScfValidatorExecutor validatorExecutor;


    public ScfMethodValidationInterceptor(ScfValidatorExecutor validatorExecutor) {
        this.validatorExecutor = validatorExecutor;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        if (isFactoryBeanMetadataMethod(invocation.getMethod())) {
            return invocation.proceed();
        }

        Object[] arguments = invocation.getArguments();

        ScfValidationErrors errors = new ScfValidationErrors();

        for (Object argument : arguments) {
            validatorExecutor.validate(argument, errors);
        }

        if (errors.hasError()) {
            throw new ScfValidationException(errors);
        }

        return invocation.proceed();
    }

    private boolean isFactoryBeanMetadataMethod(Method method) {
        Class<?> clazz = method.getDeclaringClass();

        // Call from interface-based proxy handle, allowing for an efficient check?
        if (clazz.isInterface()) {
            return ((clazz == FactoryBean.class || clazz == SmartFactoryBean.class) &&
                    !method.getName().equals("getObject"));
        }

        // Call from CGLIB proxy handle, potentially implementing a FactoryBean method?
        Class<?> factoryBeanType = null;
        if (SmartFactoryBean.class.isAssignableFrom(clazz)) {
            factoryBeanType = SmartFactoryBean.class;
        } else if (FactoryBean.class.isAssignableFrom(clazz)) {
            factoryBeanType = FactoryBean.class;
        }
        return (factoryBeanType != null && !method.getName().equals("getObject") &&
                ClassUtils.hasMethod(factoryBeanType, method));
    }
}
