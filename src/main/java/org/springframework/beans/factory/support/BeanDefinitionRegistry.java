package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 11:50
 * @Description BeanDefinition注册表接口
 **/
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName,BeanDefinition beanDefinition);
}
