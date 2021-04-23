package atguigu.java;

/**
 * TODO
 *
 * @author JClearLove
 * @date 2021/04/14 11:16
 */

public class ThreadTestDemo {
    public static void main(String[] args) {
        MythreadDemo mythreadDemo = new MythreadDemo();
        mythreadDemo.run();
    }

    private static class MythreadDemo extends Thread {
        @Override
        public void run() {
            System.out.println("\"HEHEHHEHHE\" = " + "HEHEHHEHHE");
        }
    }


}

