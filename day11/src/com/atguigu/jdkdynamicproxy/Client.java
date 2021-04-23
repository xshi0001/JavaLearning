package com.atguigu.jdkdynamicproxy;

import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/14 15:49
 */

public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        TargetSubject ts = new TargetSubject();
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(ts.getClass().getClassLoader(), ts.getClass().getInterfaces(),
                new BeforeAfterActions(ts));
        Info info = proxyInstance.doThingsNameOfThing();

        // d

        System.out.println("i = " + info.toString());

    }
}

