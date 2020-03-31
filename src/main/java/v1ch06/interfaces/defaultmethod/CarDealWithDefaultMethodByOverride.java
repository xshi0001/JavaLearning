package v1ch06.interfaces.defaultmethod;

/**
 * 解决两个接口默认方法的冲突，自己实现默认方法
 */
public class CarDealWithDefaultMethodByOverride implements Vehicle, FourWheeler {
    @Override
    public void print() {
        System.out.println("我是一辆四轮汽车!");
    }
}