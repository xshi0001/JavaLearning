package com.atguigu.java1;

import org.junit.Test;

/**
 *  lambda表达式
 *
 * @author JClearLove
 * @date 2021/04/23 10:21
 */

public class LambdaDemoTwo {

    @Test
    public void testLambda() {
        MyFunctionInterface own = String::toUpperCase;
        String ownValue = own.getValue("Hello World");
        MyFunctionInterface you = (String str) -> str.substring(3, 5);
        System.out.println("you.getValue(ownValue) = " + you.getValue(ownValue));
    }

    @Test
    public void testLambdaTwo() {
        LambdaDemoSecond<Long, Long> sumTwoValue = (Long o1, Long o2) -> o1 + o2;
        System.out.println("sumTwoValue.calculate(1L, 2L) = " + sumTwoValue.calculate(1L, 2L));
        LambdaDemoSecond<Integer, Integer> multiplyTwoValue = (Integer o1, Integer o2) -> o1 * o2;
        System.out.println("multiplyTwoValue.calculate(2, 3) = " + multiplyTwoValue.calculate(2, 3));
    }
}

