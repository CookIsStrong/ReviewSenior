package com.zhangqun.java;

import org.junit.Test;

/** 常用方法（排序）
 * @author zhangqun
 * @create 2021-09-09 15:13
 */
public class ChoiceTest {
    /*
    插入排序法
     */
    @Test
    public void test(){
//        int[] ints = {1, 2, 24134, 43, 3434, 3254};
//        for (int i = 1; i < ints.length; i++){
//            int temp = ints[1];
//            for (int j = i - 1; j >= 0; j--){
//                if (temp > ints[j]){
//                    break;
//                }else{
//
//                    ints[i] = ints[j];
//                }
//            }
//        }
    }
    /*
    选择排序法
     */
    @Test
    public void test1(){
        int[] arr = {1, 2, 454, 73465, 734};
        System.out.println("排序前：");
        for (int i = 0 ; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++){
            int lowestINdexNumber = i;
            for (int j = i + 1; j < arr.length; j++){
                //当前循环中最小值的查找
                if (arr[j] < arr[lowestINdexNumber]){
                    lowestINdexNumber = j;
                }
            }
            //判断是否交换位置
            if (lowestINdexNumber != i){
                int temp = arr[i];
                arr[i] = arr[lowestINdexNumber];
                arr[lowestINdexNumber] = temp;
            }
        }
        System.out.println("排序后：");
        for (int i = 0 ; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
    }


    /*
    冒泡排序法
     */
    @Test
    public void test2(){
        int[] ints = {1, 2, 3254, 3654, 85, 68, 3, 6, 34};
        System.out.println("排序前：");
        for (int num : ints){
            System.out.print(num+" ");
        }

        //关键
        for (int i = 0; i < ints.length; i++){
            for (int j = 0; j < ints.length - i - 1; j++){
                if (ints[j]>ints[j+1]){
                    int temp = ints[j];
                    ints[j] =ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }

        System.out.println();
        System.out.println("排序后：");
        for (int num1 : ints){
            System.out.print(num1+" ");
        }
    }

    public static void main(String[] args) {
        //递归的测试
        ChoiceTest choiceTest = new ChoiceTest();
        System.out.println(choiceTest.show(10));//特定的计算
        System.out.println(choiceTest.DiGui(5));//用于求积
        System.out.println(choiceTest.sum(100));//用于求和

    }
   //递归一
    public int show(int i){
        int sum;
        if (i == 1){
            return 1;
        }
        else if (i == 2){
            return 2;
        }else{
            return  show(i - 1) + show(i -2);
        }
    }
    //递归二
    public int DiGui(int n){
        if (n == 1){
            return 1;
        }
        return DiGui(n - 1)*n;
    }
    //递归三
    public int sum(int k){
        if(k ==1){
            return 1;
        }
        return sum(k-1)+k;
    }

}
