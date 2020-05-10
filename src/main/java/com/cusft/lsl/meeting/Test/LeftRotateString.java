package com.cusft.lsl.meeting.Test;

import java.util.Arrays;

/**
 * 多易网络面试题：
 *  数组循环右移：举例：两个数字交换位置
 *          a=a + b;
 *          b=a - b;
 *          a=a - b;
 *          此时b存储的就是a的值，b存储就是a的值
 *
 * @author Long
 * @Date 2020/4/18 14:12
 */
public class LeftRotateString {
    public static void main(String[] args) {
        System.out.println(change("abcdefgh".toCharArray(),3));
    }

    public static char[] change(char[] c,int k){

        System.out.println("原始数据"+Arrays.toString(c));
        //此时是交换了不同位置的值：如a和b的值，
        //首位和第3位
        //首先将数组要移动的部分先交换，如，5个数字的顺序要交换的话（1,2,3,4,5），只要交换2次即可（5,4,3,2,1），
        //这里前面移3位，移动（交换）一次即可，

        for(int i=0;i<k/2;i++){
            /*c[i]^=c[j]^=c[i]^=c[j];*/
            int j = k-i-1;
            c[i]=(char) (c[i]+c[j]);
            c[j]=(char) (c[i]-c[j]);
            c[i]=(char) (c[i]-c[j]);
            System.out.println("第一处"+Arrays.toString(c));
        }
        System.out.println("一     "+Arrays.toString(c));
//        System.out.println("第一处"+Arrays.toString(c));
        //左移：实现前面的移到末尾，比如，a[2]移到a[7],a[3]移到a[6]

        //这里要移动后面保持顺序的那几位，（8-3）/2=2即移动两次，两两交换

        for(int n=0;n<(c.length-k)/2;n++){
            int j=c.length-1-n;
            int i=k+n;
            c[i]=(char) (c[i]+c[j]);
            c[j]=(char) (c[i]-c[j]);
            c[i]=(char) (c[i]-c[j]);
            System.out.println("第二处"+Arrays.toString(c));
        }
        System.out.println("二  "+Arrays.toString(c));
        //交换一半
        for(int i=0;i<c.length/2;i++){
            int j=c.length-1-i;
            c[i]=(char) (c[i]+c[j]);
            c[j]=(char) (c[i]-c[j]);
            c[i]=(char) (c[i]-c[j]);
            System.out.println("第三处"+Arrays.toString(c));
        }
        System.out.println("三  "+Arrays.toString(c));
        return c;
    }
}