package com.zhangqun.java3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author zhangqun
 * @create 2021-08-25 21:14
 */
public class PropertiesTest {
    //Properties:常用来处理配置文件。key-value都是String类型
    public static void main(String[] args) throws FileNotFoundException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\IDEA\\ReviewSenior\\Coolections\\src\\jdbc.properties");
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = properties.getProperty("name");
        System.out.println(name);

        String password = properties.getProperty("password");
        System.out.println(password);
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
