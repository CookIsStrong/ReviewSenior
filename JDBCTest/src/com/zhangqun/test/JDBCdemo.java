package com.zhangqun.test;

import java.sql.*;

/**
 * @author zhangqun
 * @create 2021-10-22 4:53
 */
public class JDBCdemo {
    public static void main(String[] args) {
        ResultSet rs = null;
        Statement state = null;
        Connection conn = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "admin");
            //3.获取声明
            state = conn.createStatement();

            String sql = "select * from user";

            //执行sql语句
            rs = state.executeQuery(sql);
            //输出结果集
            while (rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " +
                rs.getString("pwd"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (state != null){
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
