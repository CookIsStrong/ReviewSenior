package com.zhangqun.java1;

/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张——使用继承于Thread方式实现
 *
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this来充当同步监视器。考虑当前类来充当同步监视器
 *
 */

class DOg{

}

class Window extends Thread {
    static int ticket = 100;
    static Object object = new Object();
    static DOg dog = new DOg();

    @Override
    public void run() {
        while (true) {
            //Window.class 也是一个对象，也可以用来充当同步代码块
            synchronized (object){
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "卖票：票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
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
