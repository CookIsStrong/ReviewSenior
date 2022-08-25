package com.zhangqun.java1;
/**
 * 使用同步方法解决继承Thread类的方式的线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张——使用继承于Thread方式实现
 *
 *
 */
class Window4 extends Thread {
    //由于存在多个对象，共享需要用static修饰
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
              show();
        }
    }
    private static void show(){//此时同步监视器：Window4.class
    //public synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票：票号为" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 window1 = new Window4();
        Window4 window2 = new Window4();
        Window4 window3 = new Window4();
        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();
    }
}