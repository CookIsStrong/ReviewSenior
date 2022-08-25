package com.zhangqun.java3;

/**
 *  通信线程的例子：使用两个打印打印1-100。线程1，线程2，交替打印
 *
 *  涉及到的三种方法
 *  wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 *  notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的。
 *  notifyAll():一旦执行此方法，就会唤醒所有的被wait的线程。
 *
 *  说明：
 *  1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或者同步方法中。
 *  2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或者同步方法的同步监视器。
 *      否则，会出现IllegalMonitorStateExeception
 *
 *  3.wait(),notify(),notifyAll()三个方法是定义在java.lang.Object类中
 *
 *  面试题：sleep()和wait()的异同
 *     1.相同点：都可以使当前的方法进入阻塞状态。
 *     2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *              2)调用的范围不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或者同步方法中。
 *              3）关于是否释放同步监视器：如果两个方法都是用在同步代码块或者同步方法中，wait()会释放锁，sleep()不会释放锁。
 *
 * @author zhangqun
 * @create 2021-07-29 20:56
 */
class Number implements Runnable{
    private int number=1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                this.notify();
                if (number<=100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        //使得调用wait()的线程进入阻塞状态
                       this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }
        }

    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);
        thread1.setName("线程一");
        thread2.setName("线程二");
        thread1.start();
        thread2.start();
    }
}
