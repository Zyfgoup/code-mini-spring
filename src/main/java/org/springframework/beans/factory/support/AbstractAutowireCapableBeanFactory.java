package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 11:56
 * @Description
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        return doCreateBean(name,beanDefinition);
    }

    protected Object doCreateBean(String name, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getBeanClass();
        Object bean = null;

        try {
            bean = clazz.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            throw new BeansException("实例化错误");
        }
        //加进单例注册表
        addSingleton(name,bean);
        return bean;
    }


}
