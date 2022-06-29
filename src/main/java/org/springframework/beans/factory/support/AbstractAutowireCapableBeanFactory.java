package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 11:56
 * @Description
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        return doCreateBean(name,beanDefinition);
    }

    protected Object doCreateBean(String name, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getBeanClass();
        Object bean = null;

        try {
            //由具体的实例化策略来实例化Bean
            bean = createBeanInstance(beanDefinition);
        }catch (Exception e){
            throw new BeansException("实例化错误");
        }
        //加进单例注册表
        addSingleton(name,bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition){
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }




}
