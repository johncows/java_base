package com.kk.proxy2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kk
 * @dare 2018/8/15 - 10:22
 */

//该接口作为业务增强的
public class proxy2 implements InvocationHandler {
    private Object factory;


           public Object getproxyInstance() {
            Object instance = Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(),
                    this);
            return instance;

    }


    public void setFactory(Object factory) {
        this.factory = factory;
    }

    //业务增强方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = method.invoke(factory, args);
        after();
        return ret;
    }

    public void before() {
        System.out.println("终于开始了！！！");
    }

    public void after() {
        System.out.println("刚结束了！！");
    }


}
