package com.alibaba.dubbo.demo.startup;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qinpr on 2019/1/18.
 */
public class ProviderStartUp {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-provider-start.xml"});
        context.start();
        System.in.read(); // press any key to exit
    }
}
