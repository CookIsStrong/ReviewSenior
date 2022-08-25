package com.zhangqun.java3;

/**
 * 线程通信的例子：经典例题：生产者/消费者问题
 * <p>
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能
 * 持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中
 * 有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如果店中有
 * 产品了再通知消费者来取走产品。
 * <p>
 * 分析：
 * 1.是否是多线程问题？是，生产者线程，消费者线程。
 * 2.是否有共享数据？是，店员（或者产品）
 * 3.如何解决线程的安全问题？同步机制，有三种方法。
 * 4.是否涉及到线程的通信？是
 *
 * @author zhangqun
 * @create 2021-07-29 23:14
 */

class Clerk {
    private int count=0;

    //生产产品
    public synchronized void produceProduct() {
        if (count<20){
            count++;
            System.out.println(Thread.currentThread().getName()+"：开始生产第"+count+"个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumeProduct() {
        if (count>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+count+"个产品");
            count--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {//生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"生产产品...");
        
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread {//消费者
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"消费产品...");

        while (true){
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        producer.setName("生产者一");
        producer.start();
        Consumer consumer1 = new Consumer(clerk);
        Consumer consumer2 = new Consumer(clerk);
        consumer1.setName("消费者一");
        consumer2.setName("消费者二");
        consumer1.start();
        consumer2.start();
    }
}
