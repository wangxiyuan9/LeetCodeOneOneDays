package com.wxy.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * 15. 三数之和
 * 输入：nums = [-1,0,1,2,-1,-4]
 * [-4,-1,-1,0,1,2]
 * 遍历其中一个数 循环里剩下两个数作为双指针
 * 输出：[[-1,-1,2],[-1,0,1]]
 * Author: wxy
 * Date: 2022/7/20 21:53
 */
public class Lt02 {
    public static void main(String[] args) {
        System.out.println(new Solution01().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}

class Solution01 {
    public List<List<Integer>> threeSum(int[] nums) {
        //base case
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(nums.length<3){
            return res;
        }
        //first sort
        Arrays.sort(nums);
        int l = 0,r = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i!=0 && nums[i-1]==nums[i]){
                //消除 [-1,-1] 假设判断了-1 1.有答案了，后一个-1一样的答案重复了排除 2.前一个-1没有答案后一个也没有答案
                continue;
            }
            //normal
            //init l,r
            l = i+1;
            r = nums.length-1;
            while (l<r){//l==r false
                if(nums[i]+nums[l]+nums[r]>0)
                    r--;
                else if(nums[i]+nums[l]+nums[r]<0)
                    l++;
                else{//==
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[l]);
                    arrayList.add(nums[r]);
                    res.add(arrayList);
                    //-1 0(l) 0  0  1  1  1(r) 也会重复
                    while((l<nums.length  && r>0 && l<r) &&(nums[l]==nums[l+1] || nums[r]==nums[r-1]) ){
                        if(nums[l]==nums[l+1])
                            l++;
                        else if(nums[r]==nums[r-1])
                            r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
