package org.springframework.beans.factory.config;

import org.springframework.beans.factory.PropertyValues;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 11:29
 * @Description BeanDefinition实例保存bean的信息，包括class类型、属性、方法构造参数、是否为单例等，此处简化只包含class类型
 **/
public class BeanDefinition {
    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass){this.beanClass = beanClass;}

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass(){return beanClass;}

    public void setBeanClass(Class beanClass){this.beanClass = beanClass;}

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
