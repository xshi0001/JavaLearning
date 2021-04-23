package com.atguigu.java1;

import com.atguigu.java2.Employee;
import org.junit.Test;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/23 09:47
 */

public class LambdadDemo {

    @Test
    public void test1() {
        Employee c = new Employee(1, "c", 12, 10.2);
        Employee a = new Employee(1, "a", 10, 10.2);
        Employee b = new Employee(1, "b", 12, 10.2);
        ArrayList<Employee> list = new ArrayList<>();
        list.add(b);
        list.add(a);
        list.add(c);
        // 先年龄再姓名
        list.sort((o1, o2) -> {
            if (o1.getAge() != o2.getAge()) {
                return o1.getAge() - o2.getAge();
            } else {
                return o2.getName().compareTo(o1.getName());
            }
        });
        System.out.println(list);
    }
}

