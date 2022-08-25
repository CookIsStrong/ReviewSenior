package com.zhangqun.test;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 *Description 资源释放的标准代码及其单条记录的查询
 *@author ZhangQun Email:32649303@qq.com
 *@version
 *@Date 2021年4月24日下午6:11:09
 */
public class JdbcDemo2 {
    @Test
    public void demoTest() {
        {
            Connection conn=null;
            Statement state=null;
            ResultSet rs=null;
            try{
                //1.加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                //2.获得连接
                conn=DriverManager.getConnection
                        ("jdbc:mysql:///plastic","root","admin");//简写
                //3.连接数据库：执行sql语句
                state=conn.createStatement();
                String sql="select * from register";
                rs=state.executeQuery(sql);//存在返回值
                while(rs.next()){
                    System.out.println(rs.getInt("id")+" "+rs.getString("username")+" "+ rs.getString("name")+"  "+ rs.getString("sex")+"  "+ rs.getString("email"));
                }
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
            finally
            {
                if(state!=null){
                    try{
                        state.close();
                    }catch(Exception e2){
                        e2.printStackTrace();
                    }finally{
                        state=null;
                    }
                    if(conn!=null){
                        try{
                            conn.close();
                        }catch(Exception e3){
                            e3.printStackTrace();
                        }finally{
                            conn=null;
                        }
                    }
                    if(rs!=null){
                        try{
                            rs.close();
                        }catch(Exception e4){
                            e4.printStackTrace();
                        }finally{
                            rs=null;
                        }
                    }
                }
            }
        }
    }
}


