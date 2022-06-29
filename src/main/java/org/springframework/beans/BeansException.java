package org.springframework.beans;

/**
 * @Author Zyfgoup
 * @Date 2022/6/29 11:19
 * @Description
 **/
public class BeansException extends RuntimeException {

    public BeansException(String msg){super(msg);}

    public BeansException(String msg,Throwable cause){super(msg,cause);}
}
