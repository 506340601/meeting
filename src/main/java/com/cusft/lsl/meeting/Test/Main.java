package com.cusft.lsl.meeting.Test;

/** 实现字符数组的循环左移3为：
 *  abcdefgh 变为 defghabc
 *
 * @author Long
 * @Date 2020/4/19 11:39
 */
public class Main {
    public static void main(String args[]){
        System.out.println(move("abcdefg".toCharArray(),3));
    }

    private static char[] move(char[] a, int k) {
        //步骤一：交换要操作的那部分
        for(int i =0;i<k/2;i++){
            int j=k-i-1;
            a[i]=(char)(a[i]+a[j]);
            a[j]=(char)(a[i]-a[j]);
            a[i]=(char)(a[i]-a[j]);
        }
        //步骤二：交换末尾要交换的那部分
        for (int i = 0; i <(a.length-k)/2 ; i++) {
            int j=a.length-i-1;
            int n=k+i;
            a[n]=(char)(a[n]+a[j]);
            a[j]=(char)(a[n]-a[j]);
            a[n]=(char)(a[n]-a[j]);
        }
        //最后一步，整体交换一半
        for (int i = 0; i <a.length/2 ; i++) {
            int j=a.length-i-1;
            a[i]=(char)(a[i]+a[j]);
            a[j]=(char)(a[i]-a[j]);
            a[i]=(char)(a[i]-a[j]);
        }
        return a;
    }

}
