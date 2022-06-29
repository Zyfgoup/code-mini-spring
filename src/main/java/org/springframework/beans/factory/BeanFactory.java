package org.springframework.beans.factory;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 11:18
 * @Description bean工厂
 **/
public interface BeanFactory {

    /**
     * 获取bean
     * @param name
     * @return
     */
     Object getBean(String name);
}
