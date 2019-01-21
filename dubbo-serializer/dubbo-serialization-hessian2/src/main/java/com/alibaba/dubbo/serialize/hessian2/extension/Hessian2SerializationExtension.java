package com.alibaba.dubbo.serialize.hessian2.extension;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.support.hessian.Hessian2Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by qinpr on 2019/1/17.
 */
public class Hessian2SerializationExtension extends Hessian2Serialization {
    public static final byte ID = 2;

    @Override
    public byte getContentTypeId() {
        return ID;
    }

    @Override
    public String getContentType() {
        return "x-application/hessian2";
    }

    @Override
    public ObjectOutput serialize(URL url, OutputStream out) throws IOException {
        return new Hessian2ObjectOutputExtension(out);
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream is) throws IOException {
        return new Hessian2ObjectInputExtension(is);
    }
}
