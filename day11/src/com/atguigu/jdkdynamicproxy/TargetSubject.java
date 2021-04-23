package com.atguigu.jdkdynamicproxy;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/14 15:37
 */

public class TargetSubject implements Subject {
    private static int nums = 10;

    @Override
    public void doAnotherThing() {
        System.out.println("我要做另一个事情了。。。");
    }

    @Override
    public int doHowMuchThing() {
        return nums;
    }

    @Override
    public Info doThingsNameOfThing() {
        String s = String.valueOf(nums);
        return new Info(s);
    }

    @Override
    public void doSomeThing() {
        System.out.println("基于上面的事情我做事情中。。");
    }
}

