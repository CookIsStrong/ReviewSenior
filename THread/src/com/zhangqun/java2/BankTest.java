package com.zhangqun.java2;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author zhangqun
 * @create 2021-07-29 10:41
 */
public class BankTest {
    public static void main(String[] args) {
        Bank instance1 = Bank.getInstance();
        Bank instance2 = Bank.getInstance();
        System.out.println(instance1 == instance2); //true表明本质是同一个对象
    }
}

class Bank {
    private static Bank instance = null;

    //为了不创建对象，设置为private
    private Bank() {

    }

    public static Bank getInstance() {
        //效率稍差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//
//            }
//            return instance;
//        }

        //方式二：效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
