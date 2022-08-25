package com.zhangqun.test;

import java.sql.*;
import java.util.Scanner;

/**
 * @author zhangqun
 * @create 2021-10-22 5:19
 */
public class JDBCdemo4 {
    public boolean login2(String name, String pwd){
        if (name == null || pwd == null){
            return false;
        }
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "admin");
            state = conn.createStatement();
            String sql = "select * from user where name = '"+name+"' and pwd = '" + pwd + " '";
            rs = state.executeQuery(sql);
            return rs.next();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (rs != null){
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
        return false;
    }
    public static void main(String[] args) {
        JDBCdemo4 jdbCdemo4 = new JDBCdemo4();

        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String pwd = input.next();

        boolean flag = jdbCdemo4.login2(name, pwd);
        if (flag){
            System.out.println("登录成功！");
        }else{
            System.out.println("用户名或者密码错误！");
        }
    }
}
