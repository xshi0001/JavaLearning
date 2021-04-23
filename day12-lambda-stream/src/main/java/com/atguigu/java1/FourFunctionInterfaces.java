package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 学习四种内置的函数式接口
 *
 * @author JClearLove
 * @date 2021/04/23 11:09
 */

public class FourFunctionInterfaces  {


    public void happyTime(double time, Consumer<Double> consumer) {
        consumer.accept(time);
    }


    @Test
    public void testConsumer() {
        happyTime(500, new Consumer<Double>() {
            // 消费的业务代码
            @Override
            public void accept(Double aDouble) {
                System.out.println("aDouble = " + aDouble);
            }
        });
    }

    @Test
    public void testConsumerLambda() {
        Consumer<Double> myConsumer = (Double d) -> {
            System.out.println("aDouble = " + d);
        };
        happyTime(500, myConsumer);
    }

    /**
     * 定义一种处理字符串的规则（{@link Predicate}）来制定，如果符合就加入的新的list中
     *
     * @param list      被处理list
     * @param predicate 过滤规则
     * @return 过滤后的list
     */
    public List<String> filterStrs(List<String> list, Predicate<String> predicate) {
        ListIterator<String> iterator = list.listIterator();
        ArrayList<String> res = new ArrayList<>();
        while (!iterator.hasNext()) {
            String next = iterator.next();
            if (predicate.test(next)) {
                res.add(next);
            }
        }
        return res;
    }

    @Test
    public void testFilterStrs() {
        ArrayList<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 5; i < 10; i++) {
            list.add("" + random.nextInt(i));
        }
        List<String> res = filterStrs(list, (s) -> s.length() > 2);
        System.out.println("res = " + res);
    }

    @Test
    public void testFunction(){
        Function<Integer, Integer> functionA = (i) -> (i + 1 );
        Function<Integer, Integer> functionB = (j) -> (j - 1);
        functionA.apply(functionB.apply(3));

        // 函数迭代
        Function<Integer, Integer> compose = functionA.compose(functionB);
        compose.apply(10);



    }



}


