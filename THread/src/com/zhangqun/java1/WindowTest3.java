package com.zhangqun.java1;

/**
 *  使用同步方法来解决实现Runnable接口的线程安全问题
 *
 *  关于同步方法的总结：
 *  1.同步方法仍然涉及到同步监视器，只是不想要我们显示的声明
 *  2.非静态的同步方法：同步监视器是：this
 *    静态的同步方法：同步监视器是：当前类本身
 *
 *
 */

class Window3 implements Runnable {
    //不需要用static修饰
    int ticket = 100;
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private synchronized void show(){ //同样有同步监视器，且为：this
        if (ticket > 0) {
            //出现错票概率大
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

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window = new Window3();

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
