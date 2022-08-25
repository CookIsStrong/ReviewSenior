package com.zhangqun.java;

/**
 * Thread类中常用方法的测试
 * 1.start():启用当前线程；调用当前线程的run()
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程a中调用线程b的join()，此时线程a进入阻塞状态，直到线程b执行完全后，线程a才结束
 * 阻塞状态
 * 8.stop():已经过时。当执行此方法时，强制结束当前线程
 * 9.sleep(long millitime):让当前线程“睡眠”指定的“millitime”毫秒数，在此时间内，当前线程是
 * 阻塞状态
 * 10.isAlive():判断当前线程是否存活
 * <p>
 * 现成的优先级：
 * 1.
 * MAX_PRIORITY=10;
 * NORM_PRIORITY=5;   -->默认优先级
 * MIN_PRIORITY=1;
 * 2.如何设置和获取当前线程的优先级：
 * getPriority():获取当前线程的优先级
 * setPriority(int p):设置当前线程的优先级
 * <p>
 * 说明：高优先级的线程要抢占低优先级线程的cpu执行权。但是只是从概率上讲，高优先级的线程高概率的情况下
 * 被执行。并不意味着只有当高优先级的线程执行完后，低优先级的线程才会执行。
 */
class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 1) {
//                try {
//                    sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(getName() + ":" + getPriority() + "-" + i);
            }
//            if (i % 20 == 1) {
//                this.yield();
//            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("Thread1");

        //设置分线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        //给主线程设置优先级
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + "-" + i);
            }
//            if (i == 20) {
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(t1.isAlive());
    }
}
