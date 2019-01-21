package com.alibaba.dubbo.serialize.hessian2.filter;



import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.common.serialize.Serialization;
import com.alibaba.dubbo.common.serialize.support.hessian.Hessian2Serialization;
import com.alibaba.dubbo.remoting.transport.CodecSupport;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.serialize.hessian2.extension.Hessian2SerializationExtension;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by qinpr on 2019/1/17.
 */
@Activate(group = Constants.CONSUMER)
public class ReplaceDubboHessianCodecFilter implements Filter {

    public ReplaceDubboHessianCodecFilter() {
        try {
            Field field = CodecSupport.class.getDeclaredField("ID_SERIALIZATION_MAP");
            field.setAccessible(true);
            Map<Byte, Serialization> ID_SERIALIZATION_MAP = (Map<Byte, Serialization>) field.get(null);
            Hessian2Serialization serialization=new Hessian2SerializationExtension();
            ID_SERIALIZATION_MAP.put(Hessian2Serialization.ID,serialization);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }
}
