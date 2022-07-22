package com.wxy.day09;

/**
 * Description:
 * Author: wxy
 * Date: 2022/7/22 21:43
 */
public class Lt01 {
}

class Solution {
    public int removeElement(int[] nums, int val) {
        //与最后一个作交换
        /*
        3 2 2 3
        */
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[j] = nums[i];
                j++;//couldn't fill
            }
        }
        return j;

    }
}