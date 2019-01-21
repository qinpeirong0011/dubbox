package com.alibaba.dubbo.demo.hello;

import java.io.Serializable;

/**
 * Created by qinpr on 2019/1/18.
 */
public class DemoResult implements Serializable {

    private static final long serialVersionUID = 3015191607553230200L;

    private Integer id;

    private String name;

    public DemoResult() {
    }

    public DemoResult(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
