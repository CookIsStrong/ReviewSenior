package com.zhangqun.test;

import java.sql.*;
import java.util.Scanner;

/**  使用preparedStatement 可以防止sql注入
 * @author zhangqun
 * @create 2021-10-22 5:09
 */
public class JDBCdemo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String pwd = input.next();
        JDBCdemo3 jdbCdemo3 = new JDBCdemo3();
        boolean flag = jdbCdemo3.login(name, pwd);
        if (flag){
            System.out.println("登录成功！");
        }else{
            System.out.println("用户名或者密码错误！");
        }
    }

    public boolean login(String name, String pwd){
        if (name == null || pwd == null){
            return false;
        }
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///test", "root", "admin");

            String sql = "select * from user where name = ? and pwd = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,pwd);
            //执行查询，不需要参数
            rs = ps.executeQuery();

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
            if(ps != null){
                try {
                    ps.close();
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
        //执行先后顺序
        return false;
    }
}
