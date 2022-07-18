package com.wxy.day01;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description:
 * Author: wxy
 * Date: 2022/7/14 16:53
 */
public class Lt01 {
}

class Solution01{
    public int[] twoSum(int[] nums, int target) {
       /*
       hashmap存储 查找优化 因为要下一个下标j所以用map
       第一遍for循环 nums[i]  target-nums[i]!=nums[i]&&查找target-nums[i] in hashset? o(1)
       步骤1：将数字放到hashmap
       执行判断
       */
        int[] res = {-1,-1};
        boolean[] repeats = new boolean[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                repeats[i] = true;//表示存在重复
            }else{
                map.put(nums[i],i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if((!repeats[i]&&target-nums[i]!=nums[i]&&map.containsKey(target-nums[i]))||
                    (repeats[i]&&map.containsKey(target-nums[i]))){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                break;//找到了
            }
        }
        return res;
    }
//    public static void main(String[] args) {
//        int[] ints = new Test2().twoSum(new int[]{ 3, 3}, 6);
//        System.out.println(Arrays.toString(ints));
//
//    }
}
