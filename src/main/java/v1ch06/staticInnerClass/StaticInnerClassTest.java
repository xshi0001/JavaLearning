package v1ch06.staticInnerClass;

/**
 * This program demonstrates the use of static inner classes.
 *
 * @author Cay Horstmann
 * @version 1.02 2015-05-12
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

