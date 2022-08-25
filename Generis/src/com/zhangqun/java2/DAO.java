package com.zhangqun.java2;

import java.util.List;

/**
 * @author zhangqun
 * @create 2021-08-27 10:46
 *
 * DAO：data（base） access object
 *
 */
public class DAO<T> {

    //添加一条记录
    public void add(T t){

    }

    //删除一条记录
    public boolean remove(int index){
        return true;
    }
    //修改一条记录
    public void update(int index,T t){

    }

    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录
    public List<T> getForList(int index){
        return null;
    }
    //泛型方法
    //举例：获取表中一共有多少条记录？获取员工最大的入职时间
    public <E> E getValue(){
        return null;
    }
}
