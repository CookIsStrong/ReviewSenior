package com.zhangqun.java;

/**
 * @author zhangqun
 * @create 2022-07-10 22:02
 */
class Book{
    String name = "java实战";
    public Book(){
        System.out.println("这是一本关于Java的书籍");
    }
    public Book(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + '}';
    }
}

public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class cla = Book.class;
        Object o = cla.newInstance();
        Book book = (Book) o;
        System.out.println(book.toString());
    }
}
