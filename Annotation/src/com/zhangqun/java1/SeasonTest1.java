package com.zhangqun.java1;

/** 使用enum关键字定义枚举类
 *  说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * @author zhangqun
 * @create 2021-08-09 9:53
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 autumn1 = Season1.AUTUMN;
        Season1 winter = Season1.WINTER;
        //toString():
        System.out.println(winter.toString());

        System.out.println(Season1.class.getSuperclass());

        //values():
        Season1[] values = Season1.values();
        for (int i=0 ; i< values.length; i++){
            System.out.println(values[i]);
        }
        System.out.println(values);

        //valueOf(String str):返回枚举类中对象名为objName的对象
        Season1 autumn = Season1.valueOf("AUTUMN");
        System.out.println(autumn);

        //调用重写方法
        autumn1.show();
        winter.show();
    }

}

interface  info{
  void  show();
}

//使用enum关键字定义枚举类
enum Season1 implements info{
    //1.提供当前枚举类的对象，多个对象之间用“，”隔开，末尾对象“；”，结束。
    SPRING("春天","万物复苏"){
        @Override
        public void show(){
            System.out.println("这是春天");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show(){
            System.out.println("这是夏天");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show(){
            System.out.println("这是秋天");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show(){
            System.out.println("这是冬天");
        }
    };

    //2.请声明season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象属性赋值;
    private Season1(String seasonName,String seasonDesc) {
        this.seasonName=seasonName;
        this.seasonDesc=seasonDesc;
    }


    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    //4.其他诉求2：获取枚举类对象的toString()
//    @Override
//    public String toString() {
//        return "Season{" + "seasonName='" + seasonName + '\'' + ", seasonDesc='" + seasonDesc + '\'' + '}';
//    }
//}

//    public void show(){
//        System.out.println("这是一个季节");
//    }
}

