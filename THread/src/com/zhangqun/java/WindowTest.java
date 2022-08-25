package com.zhangqun.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张——使用继承于Thread方式实现
 * <p>
 * 由于线程不安全，导致卖票最终会出现错误
 *
 *
 */
class Window extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + "卖票：票号为" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();
        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();
    }
}
