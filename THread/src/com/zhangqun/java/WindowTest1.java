package com.zhangqun.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张——使用实现Runnable接口的方式实现
 * <p>
 * 由于线程不安全，导致卖票最终会出现错误
 *
 *
 */
class Window1 implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票：票号为" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window = new Window1();

        Thread thread = new Thread(window);
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);

        thread.setName("窗口一");
        thread1.setName("窗口二");
        thread2.setName("窗口三");

        thread.start();
        thread1.start();
        thread2.start();
    }
}
