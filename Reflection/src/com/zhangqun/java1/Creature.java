package com.zhangqun.java1;

import java.io.Serializable;

/**
 * @author zhangqun
 * @create 2022-08-09 22:33
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("呼吸");
    }

    public void eat(){
        System.out.println("吃东西");
    }
}
