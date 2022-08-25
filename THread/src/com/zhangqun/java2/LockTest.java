package com.zhangqun.java2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁   ---> JDK5.0新增
 *
 * 1.面试题：synchronized 与 lock 的异同？
 *   相同：两者都可以解决线程安全问题
 *   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *   lock需要手动的去启动同步（调用lock()），也需要手动的实现同步的结束（调用unlock()）
 *
 *  2.使用优先顺序：
 *    lock() ——> 同步代码块 ——>同步方法——>
 *
 *   面试题：如何解决线程安全问题？有几种方式？
 *
 *
 *
 * @author zhangqun
 * @create 2021-07-29 17:49
 */
class Window implements Runnable {
    private int ticket = 100;
    //1.实例化
    private ReentrantLock lock= new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try{
                //2.调用锁定方法：lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票：票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }finally {
                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);
        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
