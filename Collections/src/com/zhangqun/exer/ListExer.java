package com.zhangqun.exer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author zhangqun
 * @create 2021-08-18 16:32
 */
public class ListExer {
    @Test
    public void testListRemove() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(ArrayList list) {
        list.remove(2);//删除的是list中位置为2的元素
//        list.remove(new Integer(2));//删除的是list中值为2的元素
    }
}
