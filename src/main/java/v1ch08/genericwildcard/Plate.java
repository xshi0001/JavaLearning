package v1ch08;

import java.util.List;

public class Plate<T> {
    private List<T> list;

    public Plate() {
    }

    public void add(T item) {
        list.add(item);
    }

    public T get() {
        return list.get(0);
    }

    public static void main(String[] args) {
        // 理解JVM编译和运行阶段
        Plate<Fruit> plate = new Plate<Fruit>();
        plate.add(new Fruit());
        plate.add(new Apple());
        // Plate<Fruit> plate = new Plate<Apple>();  //Error Java并不支持支持泛型的向上转型，所以不能够使用上面的写法，这样的写法在Java中是不被支持的。

        // 那有没有解决的办法呢？  ---》泛型通配符
        // Apple 是 Fruit 的子类，自然就可以正常编译了
        Plate<? extends Fruit> plate2 = new Plate<Apple>(); // plate 可以指向任何 Fruit 类对象，或者任何 Fruit 的子类对象。
        // <? extends Fruit> 其无法向 Plate 中添加任何对象，只能从中读取对象
      /*  Plate<? extends Fruit> plate2 = new Plate<Apple>();
        plate2.add(new Apple()); //Compile Error
        plate2.get();    // Compile Success*/


    }
}