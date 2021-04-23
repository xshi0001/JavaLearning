package com.atguigu.stream;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/23 14:52
 */

public class StreamTest {
    @Test
    public void testCreate() {
        List<Employee> employees = EmployeeData.getEmployees();
        // 顺序流
        Stream<Employee> stream = employees.stream();
        // 并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    @Test
    public void testCreate2() {
        int[] ints = {1, 2, 3};
        //数组获取的流
        IntStream intStream = Arrays.stream(ints);
    }

    @Test
    public void testCreate3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
    }

    @Test
    public void testCreate4() {
        Stream.iterate(0, (t) -> t + 2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }


    /**
     * 筛选与过滤
     */
    @Test
    public void testFilter() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        // 查询员工信息表中工资大于7000的
        stream.filter(employee -> employee.getSalary() > 7000).forEach(System.out::println);
        // 截断流
//        employees.stream().limit(3).forEach((employee) -> {
//            System.out.println("employee.getName() = " + employee.getName());
//        });
        employees.stream().limit(3).filter(employee -> employee.getSalary() > 7000).forEach(System.out::println);

        // 跳过前面3个

        employees.stream().skip(3).sorted((o1, o2) -> (o2.getAge() - o1.getAge())).forEach(System.out::println);

    }

    @Test
    public void testDistinct() {
        // 去重
        int[] ints = {1, 2, 1, 4};
        Arrays.stream(ints).distinct().forEach(System.out::println);
        Arrays.setAll(ints, x -> x * x);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(10);
        integers.add(1);
        System.out.println("Collections.frequency(integers, 10) = " + Collections.frequency(integers, 10));
    }

    @Test
    public void testMap() {
        // map -> List.add
        List<String> list = Arrays.asList("ab", "cdm", "sdsd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        // flatMap  -> List.addAll 集合里面套集合
        list.stream().flatMap(StreamTest::string2Stream).forEach(System.out::println);

        //  map会新建新的映射
//         List<CrossRankMoPo> crossRankMoPos = rankAllDay.stream()
//                    .map(x -> new CrossRankMoPo(x.getCrossCode(), x.getCrossName(), Double.parseDouble(x.getSaturation())))
//                    .sorted(Comparator.comparingDouble(CrossRankMoPo::getSaturation))
//                    .collect(Collectors.toList());

    }

    @Test
    public void testExec() {
        //获取员工长度大于3 的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().filter(x -> x.getName().length() > 3).forEach(x -> System.out.println(x.getName()));
        employees.stream().map(Employee::getName).filter(x -> x.length() > 3).forEach(System.out::println);
    }

    @Test
    public void testStrStream() {
        String[] strings = new String[]{"hello", "world"};
        Stream<Stream<Character>> streamStream = Arrays.stream(strings).map(StreamTest::string2Stream);
        streamStream.forEach(x -> x.forEach(System.out::println));


        // flatMap, hello+world-->变成一个stream
        Stream<Character> characterStream = Arrays.stream(strings).flatMap(StreamTest::string2Stream);
        characterStream.forEach(System.out::println);
    }

    public static Stream<Character> string2Stream(String s) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            list.add(s.charAt(i));
        }
        return list.stream();
    }


    @Test
    public void testSort() {
        // 自然排序+ 定制排序
        List<Integer> list = Arrays.asList(10, 8, 9, 16);
        list.stream().sorted().forEach(System.out::println);
        List<Employee> employeeList = EmployeeData.getEmployees();
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
    }

    /**
     * 终止流,count min max alMatch NoneMatch
     */
    @Test
    public void testTerminated() {
        // 终止操作
        // 检查所有元素是否大于18岁
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(x -> x.getAge() > 18);
        if (b) {
            System.out.println("yes!");
        }

        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().contains("马"));
        if (noneMatch) {
            System.out.println("存在马");
        }

        // findFirst
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println("first = " + first);
        // 任意条线一个
        Optional<Employee> any = employees.stream().findAny();
        // 工资大于3000的人
        long count = employees.stream().filter(x -> x.getSalary() > 5000).count();
        // 最高工资 -map map是映射
        Optional<Double> max = employees.stream().map(Employee::getSalary).max(Double::compare);
        System.out.println("max.get().doubleValue() = " + max.get());
        // 最低工资员工-不能用map
        Optional<Employee> employee = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("employee = " + employee);
    }


    /**
     * 归约
     */
    @Test
    public void testReduce(){
       
    }








}

