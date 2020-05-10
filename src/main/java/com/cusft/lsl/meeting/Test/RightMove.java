package com.cusft.lsl.meeting.Test;

import java.util.Arrays;

/**
 * @author Long 数组顺序右移
 * @Date 2020/4/19 12:46
 */
public class RightMove {
    public static void main(String[] args) {
        System.out.println(move("abcdefgh".toCharArray(),3));
    }

    private static char[] move(char[] a, int k) {
        //要操作的那三位
        for(int i=0;i<k/2;i++){
            int j=a.length-i-1;
            int n=a.length-k+i;
            a[j]=(char)(a[j]+a[n]);
            a[n]=(char)(a[j]-a[n]);
            a[j]=(char)(a[j]-a[n]);
            System.out.println("第一处"+ Arrays.toString(a));
        }
        //移动不需要操作的那几位
        for(int i=0;i<(a.length-k)/2;i++){
            int j=a.length-k-i-1;
            a[i]=(char)(a[i]+a[j]);
            a[j]=(char)(a[i]-a[j]);
            a[i]=(char)(a[i]-a[j]);
        }
        System.out.println("第二处"+ Arrays.toString(a));
        for(int i=0;i<a.length/2;i++){
            int j=a.length-i-1;
            a[i]=(char)(a[i]+a[j]);
            a[j]=(char)(a[i]-a[j]);
            a[i]=(char)(a[i]-a[j]);
        }
        return a;
    }


}
