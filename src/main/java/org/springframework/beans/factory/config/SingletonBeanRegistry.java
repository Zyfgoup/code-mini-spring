package org.springframework.beans.factory.config;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 11:46
 * @Description 单例注册表
 **/
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
