package com.atguigu.java1;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/23 10:40
 */
@FunctionalInterface
public interface LambdaDemoSecond<T, R> {
    R calculate(T o1, T o2);
}
