package com.alibaba.dubbo.serialize.hessian2.extension;

import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import com.alibaba.dubbo.common.serialize.ObjectOutput;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by qinpr on 2019/1/17.
 */
public class Hessian2ObjectOutputExtension implements ObjectOutput {

    private final Hessian2Output mH2o;

    public Hessian2ObjectOutputExtension(OutputStream os) {
        mH2o = new Hessian2Output(os);
        mH2o.setSerializerFactory(Hessian2SerializerFactoryExtension.SERIALIZER_FACTORY);
    }

    @Override
    public void writeBool(boolean v) throws IOException {
        mH2o.writeBoolean(v);
    }

    @Override
    public void writeByte(byte v) throws IOException {
        mH2o.writeInt(v);
    }

    @Override
    public void writeShort(short v) throws IOException {
        mH2o.writeInt(v);
    }

    @Override
    public void writeInt(int v) throws IOException {
        mH2o.writeInt(v);
    }

    @Override
    public void writeLong(long v) throws IOException {
        mH2o.writeLong(v);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        mH2o.writeDouble(v);
    }

    @Override
    public void writeDouble(double v) throws IOException {
        mH2o.writeDouble(v);
    }

    @Override
    public void writeBytes(byte[] b) throws IOException {
        mH2o.writeBytes(b);
    }

    @Override
    public void writeBytes(byte[] b, int off, int len) throws IOException {
        mH2o.writeBytes(b, off, len);
    }

    @Override
    public void writeUTF(String v) throws IOException {
        mH2o.writeString(v);
    }

    @Override
    public void writeObject(Object obj) throws IOException {
        mH2o.writeObject(obj);
    }

    @Override
    public void flushBuffer() throws IOException {
        mH2o.flushBuffer();
    }
}
