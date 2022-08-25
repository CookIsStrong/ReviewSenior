package com.zhangqun.exer1;

/**
 * 银行有一个账户。
 * 两个账户分别向同一个账户存3000元，每一次存1000元，存3次。每次存完打印余额。
 * <p>
 * 分析：
 * 1.是否是多线程问题？是，两个存储线程
 * 2.是否有共享数据？有，账户
 * 3.是否有线程安全问题？有
 * 4.如何解决线程安全问题？三种方式
 *
 * @author zhangqun
 * @create 2021-07-29 18:42
 */

class Account {
    private double balance;
    public Account(double balnce){
        this.balance=balance;
    }
    //存钱
    public synchronized void save(double amt){
        if (amt>0){
            balance+=amt;
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为：" + balance);
        }
    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acc) {
        this.acct = acc;
    }

    @Override
    public void run(){
        for (int i=0;i<3;i++){
            acct.save(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account t1=new Account(0);
        Customer c1 = new Customer(t1);
        Customer c2 = new Customer(t1);
        c1.setName("张群");
        c2.setName("狗屎");
        c1.start();
        c2.start();
    }
}
