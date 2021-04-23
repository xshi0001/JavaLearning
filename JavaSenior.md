# JavaSenior


## Day12-lambda-stream
1. lambda 
   - 为什么要：减少代码
   - 怎么用：针对函数式接口(只有一个方法的接口, @FunctionalInterface ),(x,y)->{function(x,y)}
   - 总结：->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只有一个参数，其一对()也可以省略,->右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），省略这一对{}和return关键字
   - Lambda表达式的本质：作为函数式接口的实例
   
 lambda表达式是为了让你忘记方法名，形参参数类型的东东！  

2. @FunctionalInterface 所有标注了该注解的接口都将能用在lambda表达式上 

  Java内置四大函数型接口
- 为什么要： 其它语言有函数编程，广泛应用在支持lambda表达式的API中
- 有哪些：java内置的4大核心函数式接口
  
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 这些定义就是类似于数学中的y = f(x)
 
 3. 方法引用
  
   方法引用就是Lambdba表达式，类::方法
 
 4. Stream API
   
   * 使用对象是集合，类似于SQL作用于数据库, 创建Stream - 中间操作 - 终止操作（只有调用终止操作，才会执行整个流过程）
   
  比较难的：
  map- 映射 y=f(x),形成新的y
  flatmap- 多个stream合并成一个


  


