package com.zhangqun.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zhangqun
 * @create 2021-09-03 13:30
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\io1\\hello.txt");

        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File file1 = new File("D:\\io\\io1\\haha.txt");
        if (!file1.exists()){
            boolean newFile = file1.createNewFile();
            if (newFile){
                System.out.println("创建成功！！");
            }
        }
    }
}
