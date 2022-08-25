package com.zhangqun.exer;

/*
  使用继承Thread类的方式：

  练习：创建两个分线程，其中一个线程遍历100以内的奇数，另一个线程遍历100以内的偶数

  好好理解，利用了构造器，直接赋予name

 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("线程1");
        t1.start();
        MyThread2 t2 = new MyThread2();
        t2.setName("线程2");
        t2.start();

        //创建Thread类的匿名子类的方式
        new MyThread1("线程3") {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    if (i % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}