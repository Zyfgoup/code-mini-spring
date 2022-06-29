package org.springframework.test.ioc;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 11:24
 * @Description
 **/
public class BeanContainerTest {


    @Test
    public void testGetBean(){
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService",new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }



}
class HelloService{
    public String sayHello(){
        System.out.println("hello");
        return "hello";
    }
}
