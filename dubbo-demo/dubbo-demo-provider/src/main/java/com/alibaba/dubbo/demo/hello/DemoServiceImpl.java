package com.alibaba.dubbo.demo.hello;

import com.alibaba.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qinpr on 2019/1/18.
 */
public class DemoServiceImpl implements DemoService {

    @Override
    public DemoResult sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return new DemoResult(1, "abc", new MyDemo());
    }
}
