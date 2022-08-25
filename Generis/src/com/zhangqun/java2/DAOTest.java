package com.zhangqun.java2;

import org.junit.Test;

/**
 * @author zhangqun
 * @create 2021-08-27 11:10
 */
public class DAOTest {
    @Test
    public void test1(){
        customerDAO customerDAO = new customerDAO();

        Customer customer = new Customer();

        customerDAO.add(customer);

        studentDAO studentDAO = new studentDAO();

        Student index = studentDAO.getIndex(1);


    }
}
