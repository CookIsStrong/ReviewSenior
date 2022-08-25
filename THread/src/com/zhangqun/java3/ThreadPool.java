package com.zhangqun.java3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 *   1.提高响应速度（减少了创建新线程的时间）
 *   2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *   3.便于线程管理
 *     corePoolSize：核心池的大小
 *     maximumPoolSize：最大线程数
 *     keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 * @author zhangqun
 * @create 2021-07-30 14:36
 */

class NumberThread implements Runnable {
    //输出偶数
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {
    //输出奇数
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的连接池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //2.提供指定的线程的操作，需要提供实现Runnable接口或者Callable接口的实现类的对象
        service.execute(new NumberThread());//适用于Runnable接口
        service.execute(new NumberThread1());//适用于Runnable接口
        //executorService.submit();//适用于Callable接口

        //3.关闭连接池
        service.shutdown();
    }
}
