package com.wxy.day07;

import com.sun.org.apache.xpath.internal.operations.Lt;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Description:
 * 26. 删除有序数组中的重复项
 * Author: wxy
 * Date: 2022/7/20 21:35
 */
public class Lt01 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 2}));
    }
}
/*
[1 1 2]->[1 2]
[1 1 2 3] [1 2 3 1]
没时间就暴力把
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int[] res =  new int[nums.length];
        int res1 = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                //false
                res[res1] = nums[i];
                res1++;
                set.add(nums[i]);
            }
        }
//        nums = res;
        //leetcode调用 原来的对象地址的
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
        return res1;
    }
}
