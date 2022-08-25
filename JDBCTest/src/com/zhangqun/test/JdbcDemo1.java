package com.zhangqun.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JdbcDemo1 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement state=null;
        try{
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得连接
            conn=DriverManager.getConnection
                    ("jdbc:mysql:///plastic","root","admin");//简写
            //3.连接数据库：执行sql语句
            state=conn.createStatement();
            String sql="insert into message values(null,'张群','世界这么大，我想出去走走！')";
//               String sql="delete from message where username='张群'";//数据库记录的删除
            int num=state.executeUpdate(sql);//存在返回值
            if(num>0)
                System.out.println("保存成功");
            }
            catch(Exception e1){
                e1.printStackTrace();
            }finally
            {
                if(state!=null) {
                    try {
                        state.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    } finally {
                        state = null;
                    }
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
        }
    }
}


