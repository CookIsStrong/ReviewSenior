package com.zhangqun.java1;

/**  被private修饰的内部类
 *
 * @author zhangqun
 * @create 2021-10-04 16:50
 */
public class InnerTest2 {
    public static void main(String[] args) {
        new Outer2().getInner2Eat();
    }
}

class Outer2{
    public void getInner2Eat(){
        Inner2 in = new Inner2();
        in.eat();
    }

    private class Inner2{
        public void eat(){
            System.out.println("我是Inner2的eat()");
        }
    }
}
