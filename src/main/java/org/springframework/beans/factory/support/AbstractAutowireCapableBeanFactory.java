package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

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
            //填充实例属性
            applyPropertyValues(name,bean,beanDefinition);
        }catch (Exception e){
            throw new BeansException("实例化错误");
        }
        //加进单例注册表
        addSingleton(name,bean);
        return bean;
    }

    /**
     * 注入bean的属性值
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try{
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                //自定义反射实现注入属性值
                //setFieldValue(bean, name, value);
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (Exception e){
            throw new BeansException("Error setting property values for bean: " + beanName, e);
        }
    }

    private void setFieldValue(Object bean, String name, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class<?> beanClass = bean.getClass();
        Field declaredField = beanClass.getDeclaredField(name);
        Class<?> type = declaredField.getType();

        //转换 只是简单的 BeanUtil里比较复杂
        if(!type.isAssignableFrom(value.getClass())){
            Object target = Integer.parseInt(value.toString());
            value = target;
        }
        declaredField.setAccessible(true);
        declaredField.set(bean, value);
    }

    private <T> T convert(Class<T> type,Object value){
        return (T)value;
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
