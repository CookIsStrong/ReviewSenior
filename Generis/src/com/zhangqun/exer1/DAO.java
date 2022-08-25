package com.zhangqun.exer1;

import java.util.*;

/**
 * @author zhangqun
 * @create 2021-09-02 17:04
 */
public class DAO<T> {
    private Map<String,T> map = new HashMap<>();

    //保存T类型的对象到Map成员变量中
     public void save(String id,T entity){
         map.put(id, entity);

     }
     //从Map中获取id对应的对象
     public T get(String id){
        return map.get(id);
     }
     //替换Map中key为id的内容，改为entity 对象
     public void  update(String id,T entity){
         if (map.containsKey(id)){
             map.put(id, entity);
         }

     }
     //返回Map中存放的所有T对象
     public List<T> list(){
         //错误的
//         Collection<T> values = map.values();
//         return (List<T>) values;
         //正确的：
         ArrayList<T> list = new ArrayList<>();
         Collection<T> values1 = map.values();
         for (T t : values1){
             list.add(t);
         }
         return list;
     }
     //删除指定的id
     public void delete(String id){
         map.remove(id);

     }
}
