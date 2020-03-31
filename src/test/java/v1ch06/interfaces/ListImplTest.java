package v1ch06.interfaces;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Author JClearLove
 * @Date 2020/03/31 16:34
 */
public class ListImplTest {


    @Test
    public void testListDefaultMethod() {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(8);
        list.add(4);
        list.add(2);
        list.add(12);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == null || o2 == null) {
                    return -1;
                }
                if (o1.compareTo(o2) > 0) {
                    return 1;
                }
                if (o1.compareTo(o2) < 0) {
                    return -1;
                }
                if (o1.compareTo(o2) == 0) {
                    return 0;
                }
                return 0;
            }
        });

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            System.out.println(integer);

        }



    }

}


















