package com.atguigu.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/14 15:38
 */

public class BeforeAfterActions implements InvocationHandler {

    private Subject subject;

    public BeforeAfterActions(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        beforeAction();
        Object result = method.invoke(subject, args);
        afterAction();
        return result;
    }

    public void beforeAction() {
        System.out.println("准备中。。。");
    }


    public void afterAction() {
        System.out.println("做完事情要总结！");
    }
}

