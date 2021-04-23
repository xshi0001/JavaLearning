package com.atguigu.java;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

/**
 * 1. List接口框架
 * <p>
 * |----Collection接口：单列集合，用来存储一个一个的对象
 * |----List接口：存储有序的、可重复的数据。  -->“动态”数组,替换原有的数组
 * |----ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
 * |----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 * |----Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 * <p>
 * <p>
 * 2. ArrayList的源码分析：
 * 2.1 jdk 7情况下
 * ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 * list.add(123);//elementData[0] = new Integer(123);
 * ...
 * list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
 * 默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 * <p>
 * 结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 * <p>
 * 2.2 jdk 8中ArrayList的变化：
 * ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没有创建长度为10的数组
 * <p>
 * list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
 * ...
 * 后续的添加和扩容操作与jdk 7 无异。
 * 2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象
 * 的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
 * <p>
 * 3. LinkedList的源码分析：
 * LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 * list.add(123);//将123封装到Node中，创建了Node对象。
 * <p>
 * 其中，Node定义为：体现了LinkedList的双向链表的说法
 * private static class Node<E> {
 * E item;
 * Node<E> next;
 * Node<E> prev;
 * <p>
 * Node(Node<E> prev, E element, Node<E> next) {
 * this.item = element;
 * this.next = next;
 * this.prev = prev;
 * }
 * }
 * <p>
 * 4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
 * 在扩容方面，默认扩容为原来的数组长度的2倍。
 * <p>
 * 面试题：ArrayList、LinkedList、Vector三者的异同？
 * 同：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 * 不同：见上
 * <p>
 * <p>
 * <p>
 * 5. List接口中的常用方法
 *
 * @author shkstart
 * @create 2019 上午 11:39
 */
public class ListTest {
    private static ArrayList list;

    /*
void add(int index, Object ele):在index位置插入ele元素
boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
Object get(int index):获取指定index位置的元素
int indexOf(Object obj):返回obj在集合中首次出现的位置
int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
Object remove(int index):移除指定index位置的元素，并返回此元素
Object set(int index, Object ele):设置指定index位置的元素为ele
List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

总结：常用方法
增：add(Object obj)
删：remove(int index) / remove(Object obj)
改：set(int index, Object ele)
查：get(int index)
插：add(int index, Object ele)
长度：size()
遍历：① Iterator迭代器方式
     ② 增强for循环
     ③ 普通的循环

     */
    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        for (int i = 0; i < 6; i++) {

            list.add(i);
        }

        list.add("hello");
        list.add("world");


        //方式一：Iterator迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("***************");

        //方式二：增强for循环
        for (Object obj : list) {
            System.out.println(obj);
        }

        System.out.println("***************");

        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }


    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        //int indexOf(Object obj):返回obj在集合中首次出现的位置。如果不存在，返回-1.
        int index = list.indexOf(4567);
        System.out.println(index);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置。如果不存在，返回-1.
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1, "CC");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的左闭右开区间的子集合
        List subList = list.subList(2, 4);
        System.out.println(subList);

        // 从源码来看    ArrayList.this.elementData[offset + index] = e;  修改suList中一个元素，list里面也会边

        // 解决这种问题， 新建一个新的集合
        ArrayList newList = new ArrayList<>(subList);

        subList.add("hello world");
        System.out.println(list);
        System.out.println(newList);


    }


    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        System.out.println(list);

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(1, "BB");
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
//        list.add(list1);
        System.out.println(list.size());//9

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));

    }

    @BeforeClass
    public static void init() {
        list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

    }

    @Test
    public void testRemove() {
        list.remove(2);
        System.out.println(list);
    }

    /**
     * Iterator和ListIterator区别
     * 我们在使用List，Set的时候，为了实现对其数据的遍历，我们经常使用到了Iterator(迭代器)。使用迭代器，你不需要干涉其遍历的过程，只需要每次取出一个你想要的数据进行处理就可以了。但是在使用的时候也是有不同的。List和Set都有iterator()来取得其迭代器。对List来说，你也可以通过listIterator()取得其迭代器，两种迭代器在有些时候是不能通用的，Iterator和ListIterator主要区别在以下方面：
     * <p>
     * （1）ListIterator有add()方法，可以向List中添加对象，而Iterator不能
     * （2）ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。
     * （3）ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。
     * （4）都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iterator仅能遍历，不能修改。
     */
    @Test
    public void testIterator() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ListIterator<String> listIt = list.listIterator();
        while (listIt.hasNext()) {
            String next = listIt.next();
            System.out.println("next = " + next);
            //可以进行删除，但是不能同时进行增加或者删除
            listIt.add("d");
//            listIt.remove();

        }

        System.out.println("list = " + list);
    }


}
