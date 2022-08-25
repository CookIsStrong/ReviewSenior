package com.zhangqun.java;

/**  静态代理举例
 *   特点：代理类和被代理类在编译期间，就确定下来了
 * @author zhangqun
 * @create 2022-08-15 16:53
 */

interface ClothFactory{
    void produceCloth();
}

//代理类
class ClothProxyFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类对象进行实例化

    public ClothProxyFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {

        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一些运动服装");
    }
}
public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothProxyFactory clothProxyFactory = new ClothProxyFactory(nikeClothFactory);

        clothProxyFactory.produceCloth();

    }
}
