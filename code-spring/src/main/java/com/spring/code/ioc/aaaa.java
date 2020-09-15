package com.spring.code.ioc;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public interface aaaa {
    Class<?> getType(String name) throws NoSuchBeanDefinitionException;;
}
