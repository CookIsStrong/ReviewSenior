package com.zhangqun.java;

/**
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建了一个实现了Runnable接口的类
 * 2.实现类实现Runnale中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 * <p>
 * 比较创建线程的两种方式。
 * 开发中：优先选择：实现Runnable接口的方式
 * 原因：1.实现的方式没有类的单继承性的限制
 * 2.实现的方式更适合来处理多个线程共享数据的情况
 * <p>
 * 联系：Thread类也实现了Runnable接口
 * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中
 */

//1.创建了一个类实现了Runnable接口
class MyThread2 implements Runnable {
    //2.实现类去实现Runnable接口中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MyThread2 mythread = new MyThread2();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread1 = new Thread(mythread);
        //5.通过Thread类的对象调用start():①启动线程；②调用当前线程的run()
        thread1.setName("线程一");
        thread1.start();

        //再启动一个线程，遍历一百以内的偶数
        Thread thread2 = new Thread(mythread);
        thread2.setName("线程二");
        thread2.start();
    }
}
