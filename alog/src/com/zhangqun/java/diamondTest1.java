package com.zhangqun.java;


import java.util.Scanner;

/**  菱形的判断
 *
 * @author zhangqun
 * @create 2021-09-18 14:46
 */
public class diamondTest1 {
    public static void main(String[] args) {
        diamondTest1 test1 = new diamondTest1();
        int[] ints1 = new int[]{0, 0};
        int[] ints2 = new int[]{0, 1};
        int[] ints3 = new int[]{2, 1};
        int[] ints4 = new int[]{2, 0};
        boolean square = test1.isSquare(ints1, ints2, ints3, ints4);
        System.out.println(square);
//        test1.show();
    }

    public boolean isSquare(int p1[], int p2[], int p3[], int p4[]) {
        int p[][] = {{p1[0], p1[1]}, {p2[0], p2[1]}, {p3[0], p3[1]}, {p4[0], p4[1]}};
        int cnt = 0;
        int len[] = new int[6];
        //难点
        for(int i=0;i<=3;i++){
            for(int j=i+1;j<=3;j++){
                // p[i][0]是第i个点的x坐标;p[j][1]是第j个点的y坐标
                len[cnt]=(p[i][0]-p[j][0])*(p[i][0]-p[j][0])+(p[i][1]-p[j][1])*(p[i][1]-p[j][1]);
                cnt++;
            }
        }
        //不进行排列
        //数组排序 先将所有的边的长度输出
//        Arrays.sort(len);
        //四条边相等的四边形是正方形;
        if(len[0] == len[2] && len[0] == len[3] && len[5] == len[3]){
            return true;
        }
        return false;
    }
    public void show (){
        System.out.println("请输入一个字符串：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] shuzu = str.split("");
        int n = str.length();
        int i ,j;
        for(i = 0, j = n-1; i < n; i++, j--){
            if (!shuzu[i].equals(shuzu[j])){
                break;
            }
        }
        if(i >= j){
            System.out.println(str + "是回文数");
        }else{
            System.out.println(str + "不是回文数");
            System.out.println();
        }
    }

}

