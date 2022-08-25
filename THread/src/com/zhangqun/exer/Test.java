package com.zhangqun.exer;


import java.util.ArrayList;

/**
 * @author zhangqun
 * @create 2022-03-11 15:24
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(2));//记住：这样的话删除的不是索引，而是对应的值

        System.out.println(list);

    }

    public int[] twoSum(int[] numbers, int target) {

        // 使用双指针
        //且充分使用了非递减顺序排序的条件
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[0];
    }

}
