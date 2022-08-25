package com.zhangqun.java;

/**  将数组逆序输出
 * @author zhangqun
 * @create 2021-09-15 17:00
 */
public class arrayTest {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        int N  = ints.length;

        //调整顺序前数据的输出
        System.out.println("原始数据：");
        for (int i = 0; i < N; i++){
            System.out.print(ints[i] + " ");
        }
        System.out.println();

        //颠倒顺序的具体操作步骤
        for(int i = 0; i < N/2; i++){
            int temp = ints[i];
            ints[i] = ints[N-i-1];
            ints[N-i-1] = temp;
        }

        //调整顺序后的数据输出
        System.out.println("逆序后：");
        for (int i = 0; i < N; i++){
            System.out.print(ints[i] + " ");
        }

        System.out.println();
        System.out.println("完美结束");

    }
}
