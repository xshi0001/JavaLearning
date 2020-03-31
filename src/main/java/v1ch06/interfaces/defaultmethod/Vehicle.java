package v1ch06.interfaces.defaultmethod;

public interface Vehicle {
    default void print() {
        System.out.println("我是一辆车!");
    }

    // 静态方法
    static void blowHorn() {
        System.out.println("按喇叭!!!");
    }

}