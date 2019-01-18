package com.alibaba.dubbo.demo.consumer.startup;

import com.alibaba.dubbo.demo.hello.DemoResult;
import com.alibaba.dubbo.demo.hello.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qinpr on 2019/1/18.
 */
public class ConsumerStartUp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer-start.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // get remote service proxy
        while (true) {
            try {
                Thread.sleep(1000);
                DemoResult result = demoService.sayHello("world");// call remote method
                System.out.println(result.getId() + "," + result.getName()); // get result
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
