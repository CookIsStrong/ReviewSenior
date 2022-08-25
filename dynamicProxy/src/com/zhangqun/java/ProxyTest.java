package com.zhangqun.java;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangqun
 * @create 2022-08-15 17:10
 */

interface Human{
    String getBelief();

    void eat(String food);


}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃：" + food);

    }
}

class MethodUtil{
    public void method1(){
        System.out.println("+++++++++通用方法一++++++++++");
    }

    public void method2(){
        System.out.println("++++++++++++++++通用方法二==============");
    }
}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类和对象
问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法

*/

//代理类
class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){// obj:被代理的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动地调用如下方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        //method: 即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj: 被代理类的对象

        MethodUtil methodUtil = new MethodUtil();
        methodUtil.method1();
        Object invoke = method.invoke(obj, objects);

        methodUtil.method2();

        return invoke;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superman = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superman);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("臭鳜鱼");

        System.out.println("******************");
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();

    }
}
