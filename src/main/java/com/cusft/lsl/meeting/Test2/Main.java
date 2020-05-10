package com.cusft.lsl.meeting.Test2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个集合S(没有重复元素), 输出它所有的子集
 * 输入 1 2 3 输出 1, 2, 12, 3, 13, 23, 123
 * 思路：首先先给定集合，然后给一个静态的整理方法，
 * @author Long
 * @Date 2020/4/20 10:39
 */
public class Main {
    public static void main(String[] args) {
        int[] set = new int[]{1, 2, 3};
        Set<Set<Integer>> result = getSubSet(set); // 调用方法
        // 输出结果
        for (Set<Integer> subSet : result) {
            for (Integer num : subSet)
                System.out.print(num);

            System.out.println("");
        }
    }
        public static Set<Set<Integer>> getSubSet(int[] set) {
            Set<Set<Integer>> result = new HashSet<Set<Integer>>(); // 用来存放子集的集合
            int length = set.length;
            int num = length == 0 ? 0 : 1 << (length); // 2的n次方，若集合set为空，num为0；若集合set有4个元素，那么num为16.

            // 从0到2^n-1（[00...00]到[11...11]）
            for (int i = 0; i < num; i++) {
                Set<Integer> subSet = new HashSet<Integer>();
                int index = i;
                for (int j = 0; j < length; j++) {
                    if ((index & 1) == 1) { // 每次判断index最低位是否为1，为1则把集合set的第j个元素放到子集中
                        subSet.add(set[j]);
                    }
                    index >>= 1; // 右移一位
                }

                result.add(subSet);
            }
            return result;
        }


    }


