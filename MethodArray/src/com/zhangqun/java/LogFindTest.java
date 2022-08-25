package com.zhangqun.java;

/**
 *    二分查找法
 *
 * @author zhangqun
 * @create 2021-09-09 21:00
 */
public class LogFindTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LogFindTest test = new LogFindTest();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int locate = test.test1(ints, 9);
        long end = System.currentTimeMillis();
        System.out.println(locate);
        System.out.println("花费的时间为：" + (end - start));

    }
    public int test1(int[] list, int item){
        int low = 0;
        int high = list.length - 1;
        while(low <= high){
            int mid = ( low + high ) / 2; //一定得放在里面，mid需要重置
            if(list[mid] == item){
                return mid;
            }else if(list[mid] > item){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;//没有该元素的话，就会返回-1
    }
}
