package com.zhangqun.java1;

/**
 *  使用同步代码块解决线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张——使用实现Runnable接口的方式实现
 * <p>
 * 1.问题:卖票过程中，出现了错票、重票 -->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，其他线程参与进来，也操作车票。
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来。直到线程a操作完ticket时，其他的线程
 * 才可以操作ticket。这种情况即使线程a出现了阻塞，也不能被改变。
 * 4.在Java中，我们通过同步机制，来解决线程的安全问题。
 * <p>
 * <p>
 * 方式一：同步代码块
 * <p>
 *      synchronized(同步监视器){
 *          //需要被同步的代码
 *      }
 * 说明：1.操作共享数据的代码，就是需要被同步的代码  -->不能包含代码多了，也不能包含代码少了。
 * 2.共享数据：多个线程共同操作的变量。比如：ticket
 * 3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 * 要求：多个线程必须共用同一把锁
 * <p>
 * 补充：在实现Runnable接口创建多线程的方式，我们可以考虑使用this来充当同步监视器。
 * <p>
 * <p>
 * 5.同步的方式，解决了线程安全的问题。 -->
 * 操作同步代码块时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低。  -->局限性
 * 方式二：同步方法
 */

class Window1 implements Runnable {
    //此时不需要用static修饰
    int ticket = 100;
    Object object = new Object();

    @Override
    public void run(){
        while (true) {
            //在这里 this、object、dog都可以
            synchronized (this) {
                if (ticket > 0) {

                    //出现错票概率大
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票：票号为" + ticket);

                    //出现重票概率大
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window = new Window1();

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
