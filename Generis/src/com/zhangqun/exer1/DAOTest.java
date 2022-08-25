package com.zhangqun.exer1;

import java.util.List;

/**
 * @author zhangqun
 * @create 2021-09-02 19:05
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> user = new DAO<>();

        user.save("1001",new User(1001,40,"周杰伦"));
        user.save("1002",new User(1002,30,"许嵩"));
        user.save("1003",new User(1003,50,"刘德华"));
        //更新，本质是覆盖掉之前的
        user.update("1002",new User(1002,60,"林柏祥"));

        //删除操作
        user.delete("1001");

        List<User> list = user.list();
//        Iterator<User> iterator = list.iterator();
//        while(iterator.hasNext()){
//            iterator.next();
//        }
        list.forEach(System.out::println);
    }
}
