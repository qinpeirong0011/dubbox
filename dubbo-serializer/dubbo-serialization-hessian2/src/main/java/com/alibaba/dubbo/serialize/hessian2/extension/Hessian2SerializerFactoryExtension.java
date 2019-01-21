package com.alibaba.dubbo.serialize.hessian2.extension;

import com.alibaba.com.caucho.hessian.io.Deserializer;
import com.alibaba.com.caucho.hessian.io.HessianProtocolException;
import com.alibaba.com.caucho.hessian.io.SerializerFactory;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;

/**
 * Created by qinpr on 2019/1/17.
 */
public class Hessian2SerializerFactoryExtension extends SerializerFactory {
    public static final SerializerFactory SERIALIZER_FACTORY = new Hessian2SerializerFactoryExtension();

    private Hessian2SerializerFactoryExtension() {
    }

    @Override
    public ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    @Override
    public Deserializer getDeserializer(String type) throws HessianProtocolException {
        Deserializer deserializer = super.getDeserializer(type);
        if (deserializer == null) {
            ClassPool pool = ClassPool.getDefault();
            CtClass ctClass = pool.makeClass(type);
            try {
                ctClass.toClass();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
            deserializer = super.getDeserializer(type);
        }
        return deserializer;
    }
}
