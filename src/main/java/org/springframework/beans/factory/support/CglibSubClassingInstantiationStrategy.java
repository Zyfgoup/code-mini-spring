package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 16:09
 * @Description
 **/
public class CglibSubClassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        //cglib动态生成子类
        throw new UnsupportedOperationException("CGLIB instantiation strategy is not supported");
    }
}
