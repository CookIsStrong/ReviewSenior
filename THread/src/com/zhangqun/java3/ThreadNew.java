package com.zhangqun.java3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口  -->JDK 5.0新增
 *
 *
 *  如何理解实现Callable接口的方式创建线程比实现Runnable接口的方式创建线程更强大？
 *  1.call()方法是可以有返回值的；
 *  2.call()是可以抛出异常的，被外界的操作捕获，获取异常的信息。
 *  3.Callable是支持泛型的。
 *
 * @author zhangqun
 * @create 2021-07-30 10:31
 */

//1.创建了一个实现Callable接口的实现类
class NumThread implements Callable {
    //2.实现call(),将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将Callable实现类的对象传递到FutureTask的构造器中，并创建FututrTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask的对象传递到Thread类的构造器中，创建Thread类的对象，并调用start()
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
